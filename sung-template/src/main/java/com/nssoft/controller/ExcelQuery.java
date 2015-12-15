package com.nssoft.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.servlet.ModelAndView;

import com.neighborsystem.durian.exception.AbsAPIException;
import com.neighborsystem.durian.exception.AbsException;
import com.neighborsystem.durian.restapi.api.AbsAPI;
import com.neighborsystem.durian.restapi.api.CommonTag;
import com.neighborsystem.durian.restapi.api.DurianMV;
import com.neighborsystem.durian.restapi.model.NFData;
import com.nssoft.exception.AbsHttpException;
import com.nssoft.exception.InvalidMustParameterException;
import com.nssoft.exception.InvalidValueException;
import com.nssoft.exception.ServerInternalException;
import com.nssoft.exception.UndefineParameterException;
import com.nssoft.model.ExcelObj;
import com.nssoft.util.MD5Util;

/**   
 *
 * @ClassName ExcelQuery
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年7月31日 下午2:55:01    
 * @version V1.0      
 *    
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class ExcelQuery extends AbsAPI<ExcelObj> {
private static final Log logger = LogFactory.getLog( ExcelQuery.class );
	
	private static final String perpertyPath = "/durian.properties";
	
	@Resource
	private SqlSessionFactory sqlSessionFactory = null;
	
	public SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	public String getPerpertyPath() {
		return perpertyPath;
	}
	
	public String getPropertyValue(String key) {
		try {
            Properties props = new Properties();
            InputStream inputStream = this.getClass().getResourceAsStream(perpertyPath);
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
            props.load(bf);
            return props.getProperty(key);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "";
        }
	}

	public String getHttpSession(HttpServletRequest req, String name) {
		return (String) req.getSession().getAttribute(name);
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		NFData datas = null;
		String strFormat = "json";
		String strTrId = null;
		Map paramsMap = null;
		String headerKey = "";
		try {
			datas = new NFData();
			datas.put(CommonTag.id.name(), this.getApiId());
			strTrId = createTrID(req);
			datas.put(CommonTag.trId.name(), strTrId);
			logger.info("START - TrID[" + strTrId + "] API[" + this.getApiId() + "]");
			paramsMap = req.getParameterMap();
			strFormat = _getViewType(req, res);
			checkHttpMethod(req.getMethod());
			checkHttpHeader(req, res, datas);
			checkMustParam(paramsMap);
			checkOptoinParam(paramsMap);
			checkUndefineParameter(paramsMap);
			
			//checkNullParameterValue(paramsMap);
			checkAuth(req, res);
			prepareExecute(req, res);
			datas.put(CommonTag.errCd.name(), 0);
			datas.put(CommonTag.errMsg.name(), "Success");
			datas.put("ts", req.getHeader("ts"));
			
			ExcelObj resultObj = executeAPI(req, res, strTrId);
			if (resultObj != null) {
				datas.put(CommonTag.result.name(), resultObj);
			}
			
			successExecute(req, res, datas);
		}
		catch (AbsAPIException e) {
			failExecute(req, res, datas);
			makeError(datas, e);
			logger.error("ERROR- TrID[" + strTrId + "] [" + datas.get(CommonTag.id.name()) + "] [" + e.getErrCode() + "] [" + e.getErrMessage() + "]");
			return new DurianMV(strFormat, datas);
		}
		catch (AbsHttpException e) {
			failExecute(req, res, datas);
			logger.error("ERROR- TrID[" + strTrId + "] [" + datas.get(CommonTag.id.name()) + "] [" + e.getMessage() + "]");
			throw e;
		}
		finally {
			headerKey = "timeStamp:" + req.getHeader("ts") + ";errCd:" + datas.get(CommonTag.errCd.name()) + ";trId:" + datas.get(CommonTag.trId.name()) + ";";
			res.setHeader("headerKey", MD5Util.toSHA256(headerKey));
			afterExecute(req, res);
			logger.info("END - TrID[" + strTrId + "] API[" + this.getApiId() + "]");
		}

		return new DurianMV(strFormat, datas);
	}
	
	public void checkMustParam(Map paramMap) throws AbsException {
		Class mEnumMustRequireParamClass = getMustParameter();

		if (mEnumMustRequireParamClass == null) return;
		if (paramMap == null) throw new InvalidMustParameterException("没有发现必须参数");

		String[] value = null;
		for (Object p : mEnumMustRequireParamClass.getEnumConstants()) {
			if (logger.isDebugEnabled()) {
				logger.debug("------------------------------------");
				logger.debug("必须参数 = " + p.toString());
			}

			value = (String[]) paramMap.get(p.toString());
			if (value == null || value[0].length() == 0) {
				if (logger.isDebugEnabled()) {
					logger.debug("-----------------------------------");
					logger.debug("必须参数为空 = " + p.toString());
				}
				throw new InvalidMustParameterException("必须参数为空[" + p.toString() + "]");
			}
		}
	}
	
	public void checkOptoinParam(Map paramMap) throws AbsException {
		Class mEnumOptionParamClass = getOptionParameter();

		if (mEnumOptionParamClass == null) return;
		if (paramMap == null) throw new InvalidMustParameterException("没有发现必须参数");

		String[] value = null;
		for (Object p : mEnumOptionParamClass.getEnumConstants()) {
			if (logger.isDebugEnabled()) {
				logger.debug("------------------------------------");
				logger.debug("可选参数 = " + p.toString());
			}

			value = (String[]) paramMap.get(p.toString());
			if (value == null || value[0].length() == 0) {
				if (logger.isDebugEnabled()) {
					logger.debug("-----------------------------------");
					logger.debug("可选参数为空 = " + p.toString());
				}
				//throw new InvalidMustParameterException("必须参数为空[" + p.toString() + "]");
			}
		}
	}
	
	public void checkUndefineParameter(Map mRequestMap) throws AbsException {
		if(mRequestMap == null) return;
		Set<String> set = mRequestMap.keySet();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			_checkUndefineParameter(itr.next());
		}
	}

	protected void _checkUndefineParameter(String strKey) throws AbsException {
		Class mEnumOtherParamClass = getOptionParameter();
		Class mEnumMustRequireParamClass = getMustParameter();

		if (mEnumMustRequireParamClass != null) {
			try {
				mEnumMustRequireParamClass.getField(strKey);
			}
			catch (NullPointerException e) {
				e.printStackTrace();
				throw new ServerInternalException("_checkUndefineParameter() NullPointerException");
			}
			catch (SecurityException e) {
				e.printStackTrace();
				throw new ServerInternalException("_checkUndefineParameter() SecurityException");
			}
			catch (NoSuchFieldException e) {
				if (mEnumOtherParamClass != null) {
					try {
						mEnumOtherParamClass.getField(strKey);
					}
					catch (SecurityException e1) {
						e1.printStackTrace();
						throw new ServerInternalException("_checkUndefineParameter() NoSuchFieldException >> SecurityException");
					}
					catch (NoSuchFieldException e1) {
						if (logger.isDebugEnabled()) {
							logger.debug("==========================================");
							logger.debug("不正确的参数 = " + strKey);
							logger.debug("==========================================");
						}
						throw new UndefineParameterException("未定义的参数 [" + strKey + "]");
					}
				}
				else {
					if (logger.isDebugEnabled()) {
						logger.debug("未定义的参数 = " + strKey);
					}
					throw new UndefineParameterException("未定义的参数 [" + strKey + "]");
				}
			}
		}
	}
	
	public void checkNullParameterValue(Map mRequestMap) throws AbsException {
		if(mRequestMap == null) return;
		Set<String> set = mRequestMap.keySet();
		Iterator<String> itr = set.iterator();

		String key = null;
		String[] value = null;
		int count = 0, len = 0;
		while (itr.hasNext()) {
			key = itr.next();
			value = (String[]) mRequestMap.get(key);
			len = value.length;
			for (count = 0; count < len; count++) {
				if (value[count].length() == 0)
					throw new InvalidValueException("参数 [" + key + "] 为 NULL");
			}
		}
	}
}
