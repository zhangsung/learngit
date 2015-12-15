package com.nssoft.api.error;

import java.io.IOException;
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
 * @ClassName NoSession
 * @Description
 * Copyright (c) 2014 by Ns Soft. 
 * @author xuliguo   
 * @date 2014年12月22日 上午11:07:31    
 * @version V1.0      
 *    
 */
@SuppressWarnings({ "rawtypes" })
@Controller("/v1/api/error/no-login.json")
public class NoLogin extends AbsQuery<String> {

	@Override
	public String getApiId() {
		return "auth_nosession";
	}

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.ALL;
	}

	@Override
	public String executeAPI(HttpServletRequest req, HttpServletResponse res,
			String trId) throws AbsException {
		boolean isAjaxRequest = RequestUtil.isAjaxRequest(req);
		if (isAjaxRequest) {
			throw new AuthFailException("对不起,您还未登录.");	
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
