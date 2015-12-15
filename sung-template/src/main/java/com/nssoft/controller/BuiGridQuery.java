 package com.nssoft.controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.neighborsystem.durian.exception.AbsAPIException;
import com.neighborsystem.durian.exception.AbsException;
import com.neighborsystem.durian.restapi.api.AbsAPI;
import com.neighborsystem.durian.restapi.api.DurianMV;
import com.neighborsystem.durian.restapi.api.HttpMethod;
import com.neighborsystem.durian.restapi.model.NFData;
import com.nssoft.exception.AbsHttpException;
import com.nssoft.exception.InvalidMustParameterException;
import com.nssoft.exception.InvalidValueException;
import com.nssoft.exception.ParamException;
import com.nssoft.exception.ServerInternalException;
import com.nssoft.exception.UndefineParameterException;
import com.nssoft.model.BuiGridObj;

/**   
 *
 * @ClassName AbsGridQuery
 * @Description BUI分页查询
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2014年10月12日 下午2:51:15    
 * @version V1.0      
 * @param <T>
 *    
 */
@SuppressWarnings({"unchecked" , "rawtypes"})
public abstract class BuiGridQuery<T> extends AbsAPI<T> {

	private static final Logger logger = Logger.getLogger(BuiGridQuery.class);
	
	@Resource
	private SqlSessionFactory sqlSessionFactory = null;
	
	public SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	public void checkAuth(HttpServletRequest req, HttpServletResponse res) throws AbsException {
//		if(req.getSession().getAttribute("member_id")==null)
//		throw new AuthFailException();
	};
	
	public void _transPagging(Map paramMap){
		try {
			int start = Integer.parseInt((String) paramMap.get("start"));
			int limit = Integer.parseInt((String) paramMap.get("limit"));
			int startIndex  = start;
			int endIndex =  limit;
			paramMap.remove("limit");
			paramMap.remove("start");
			
			paramMap.put("startIndex", startIndex);
			paramMap.put("endIndex", endIndex);
		} catch (Exception e) {
			logger.error(e);
			throw new ParamException("页码参数有误.");
		}
	}
	
	public HttpMethod getHttpMethod() {
		return HttpMethod.ALL;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		NFData datas = null;
		String strFormat = "json";
		String strTrId = null;
		Map paramsMap = null;
		try {
			datas = new NFData();
			strTrId = createTrID(req);
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
			T resultObj = executeAPI(req, res, strTrId);
			if (resultObj != null) { 
				BuiGridObj gridObj = (BuiGridObj) resultObj;
				datas.put("results", gridObj.getResults());
				datas.put("rows", gridObj.getRows());
				datas.put("summary", gridObj.getSummary());
				Boolean hasError = gridObj.getHasError();
				datas.put("hasError", hasError);
				if (hasError)
					datas.put("error", gridObj.getError());
			}
			successExecute(req, res, datas);
		} catch (AbsAPIException e) {
			logger.error(e);
//			datas.put("results", 0);
//			datas.put("rows", new ArrayList());
			datas.put("hasError", true);
			datas.put("error", e.getMessage());
		} catch (AbsHttpException e) {
			logger.error(e);
//			datas.put("results", 0);
//			datas.put("rows", new ArrayList());
			datas.put("hasError", true);
			datas.put("error", e.getMessage());
		}
		logger.info("END - TrID[" + strTrId + "] API[" + this.getApiId() + "]");
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
