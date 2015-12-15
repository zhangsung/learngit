package com.nssoft.api.error;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.neighborsystem.durian.exception.AbsException;
import com.neighborsystem.durian.restapi.api.HttpMethod;
import com.nssoft.controller.AbsQuery;
import com.nssoft.exception.AuthFailException;
import com.nssoft.util.RequestUtil;

/**   
 *
 * @ClassName AbNormal
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2014年12月26日 下午4:45:52    
 * @version V1.0      
 *    
 */
@SuppressWarnings({ "rawtypes" })
@Controller("/v1/api/error/auth-abnormal.json")
public class AbNormal extends AbsQuery<Map> {

	@Override
	public String getApiId() {
		return "auth_abnormal";
	}

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.ALL;
	}

	@Override
	public Map executeAPI(HttpServletRequest req, HttpServletResponse res,
			String trId) throws AbsException {
		boolean isAjaxRequest = RequestUtil.isAjaxRequest(req);
		if (isAjaxRequest) {
			throw new AuthFailException("您的账号异常.请重新登陆.");
		} else {
			try {
				res.sendRedirect(req.getContextPath() + "/login.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
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
