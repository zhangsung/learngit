package com.nssoft.security;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nssoft.api.oauth2.service.OAuth2Service;
import com.nssoft.util.StringUtil;

/**
 *
 * @ClassName GlobalInterceptor
 * @Description Copyright (c) 2014 by NS Soft.
 * @author xuliguo
 * @date 2015年8月11日 上午10:58:23
 * @version V1.0
 * 
 */
public class GlobalInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = Logger.getLogger(GlobalInterceptor.class);
	@Autowired
    private OAuth2Service oAuth2Service;
	
	@Resource
	private SqlSession sqlSession = null;
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object controller) throws Exception {
		
		logger.info("进入拦截器.");
		
		Subject subject = SecurityUtils.getSubject();
		/*if (!subject.isAuthenticated() && subject.isRemembered()) {
		            Object principal = subject.getPrincipal();
		            if (null != principal) {
		            		if (logger.isDebugEnabled())
		            			logger.debug("全局拦截器, 取得未登录状态记住密码机制下存储的用户凭证:" + principal);
		            		
		            		Map user = getUser((String) principal);
		            		if (user != null) {
		            			UsernamePasswordToken token = new UsernamePasswordToken((String)principal, (String)user.get("password"));
	 		                token.setRememberMe(true);
	 		                subject.login(token);
	 		                return true;
		            		}
		            }
		}*/
		
		if (!subject.isAuthenticated()) {
			
			String accessToken = request.getParameter("access-token");
			
			if (!StringUtil.isEmpty(accessToken)) {
				if (logger.isDebugEnabled())
        				logger.debug("全局拦截器, 取得未登录状态access-token:" + accessToken);
				String user_id = oAuth2Service.getUsernameByAccessToken(accessToken);
				
				if (logger.isDebugEnabled())
					logger.debug("由access-token取得user_id:" + accessToken);
				
				if (!StringUtil.isEmpty(user_id)) {
					Map user = getUser(user_id);
	            		if (user != null) {
	            			UsernamePasswordToken token = new UsernamePasswordToken(user_id, (String)user.get("password"));
			                token.setRememberMe(true);
			                subject.login(token);
			                return true;
	            		}
				}
			}
		}
		
		return true;
	}
	
	
	private Map getUser(String user_id) {
		return sqlSession.selectOne("user.getUserById", user_id);
	}
	
}
