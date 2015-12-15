package com.nssoft.api.user;

import java.io.IOException;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;

import com.neighborsystem.durian.exception.AbsException;
import com.neighborsystem.durian.restapi.api.HttpMethod;
import com.nssoft.controller.AbsQuery;
import com.nssoft.model.Success;
import com.nssoft.util.RequestUtil;

/**   
 *
 * @ClassName Logout
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年7月24日 上午9:57:39    
 * @version V1.0      
 *    
 */
@Controller("/v1/api/user/logout.json")
public class Logout extends AbsQuery<Success> {
	
	private static final Logger logger = Logger.getLogger(Logout.class);

	@Override
	public Success executeAPI(HttpServletRequest req,
			HttpServletResponse res, String arg2) throws AbsException {
		Subject subject = SecurityUtils.getSubject();
		Success success = new Success(false, "登出失败!");
		try {
			if (subject.isAuthenticated()) {
				subject.logout(); 
				boolean isAjaxRequest = RequestUtil.isAjaxRequest(req);
				if (isAjaxRequest) {
					success.setSuccess(true);
					success.setMsg("登出成功!");
					return success;
				} else {
					try {
						res.sendRedirect(req.getContextPath() + "/login.html");
					} catch (IOException e) {
						logger.error(e);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return success;
	}

	@Override
	public String getApiId() {
		return "auth_logout";
	}

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.ALL;
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
