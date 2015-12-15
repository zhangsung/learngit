package com.nssoft.api.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.neighborsystem.durian.exception.AbsException;
import com.neighborsystem.durian.restapi.api.HttpMethod;
import com.nssoft.controller.AbsQuery;
import com.nssoft.model.Success;

/**   
 *
 * @ClassName FindPassWord
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年7月24日 下午1:01:33    
 * @version V1.0      
 *    
 */
@Controller("/v1/api/user/findpw.json")
public class FindPassWord extends AbsQuery<Success> {

	@Override
	public Success executeAPI(HttpServletRequest req,
			HttpServletResponse res, String arg) throws AbsException {
		return null;
	}

	@Override
	public String getApiId() {
		return null;
	}

	@Override
	public HttpMethod getHttpMethod() {
		return null;
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
