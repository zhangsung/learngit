package com.nssoft.security;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.subject.WebSubject;
import org.apache.shiro.web.subject.WebSubject.Builder;
import com.nssoft.api.oauth2.service.OAuth2Service;
import com.nssoft.util.StringUtil;

/**   
 *
 * @ClassName ShiroFilter
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年8月11日 下午12:50:33    
 * @version V1.0      
 *    
 */
public class ShiroFilter extends AuthorizationFilter {

	@Resource
	private OAuth2Service oauth2Service;
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String accessToken = req.getParameter("access-token");
		if (!StringUtil.isEmpty(accessToken)) {
			String user_id = null;
			try {
				user_id = oauth2Service.getUsernameByAccessToken(accessToken);
			} catch (Exception e) {
				return false;
			}
			
			if (!StringUtil.isEmpty(user_id)) {
				PrincipalCollection principals = new SimplePrincipalCollection(  
		                user_id, "");  
				Builder builder = new WebSubject.Builder(req, res);  
				builder.principals(principals);  
				builder.authenticated(true);  
				ThreadContext.bind(builder.buildWebSubject());  
				
			}
		}
		return SecurityUtils.getSubject().isAuthenticated();
	}

}
