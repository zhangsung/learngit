package com.nssoft.api.common;

import org.apache.log4j.Logger;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;

import com.neighborsystem.durian.exception.AbsAPIException;
import com.neighborsystem.durian.exception.AbsException;
import com.neighborsystem.durian.restapi.api.HttpMethod;
import com.nssoft.controller.AbsQuery;
import com.nssoft.exception.ApiException;
import com.nssoft.exception.ParamException;
import com.nssoft.exception.SqlException;

/**   
 *
 * @ClassName Menu
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年8月7日 上午9:17:34    
 * @version V1.0      
 *    
 */
@SuppressWarnings("rawtypes")
@Controller("/v1/api/common/menu.json")
public class Menu extends AbsQuery<List> {
	
	private static final Logger logger = Logger.getLogger(Menu.class);

	@Override
	public String getApiId() {
		return "common_menu";
	}

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.ALL;
	}

	@Override
	public List executeAPI(HttpServletRequest req, HttpServletResponse res,
			String trId) throws AbsException {
		SqlSession session = null;
		List resultList = null;
		try {
			session = getSession();
			resultList = session.selectList("common.getMenu");
			return resultList;
		}  catch (AbsAPIException e) {
			logger.error(e);
			throw e;
		} catch (IllegalArgumentException e) {
			logger.error(e);
			throw new ParamException();
		} catch (PersistenceException e) {
			logger.error(e);
			throw new SqlException(e);
		}  catch (Exception e) {
			logger.error(e);
			throw new ApiException();
		} finally{
			if(session != null)
				session.close();
		}
	}

	@Override
	public Class getMustParameter() throws AbsException {
		return null;
	}

	@Override
	public Class getOptionParameter() throws AbsException {
		return null;
	}

}
