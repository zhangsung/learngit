package com.nssoft.api.error;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import com.neighborsystem.durian.exception.AbsException;
import com.neighborsystem.durian.restapi.api.HttpMethod;
import com.nssoft.controller.AbsQuery;
import com.nssoft.exception.ApiException;
import com.nssoft.util.RequestUtil;

/**   
 *
 * @ClassName NoAuth
 * @Description 
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2014年12月22日 上午11:11:02    
 * @version V1.0      
 *    
 */
@SuppressWarnings({ "rawtypes" })
@Controller("/v1/api/error/error500.json")
public class Error500 extends AbsQuery<String> {

	@Override
	public String getApiId() {
		return "error_error500";
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
			throw new ApiException();
		} else {
			try {
				res.sendRedirect(req.getContextPath() + "/error/error.html");
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
