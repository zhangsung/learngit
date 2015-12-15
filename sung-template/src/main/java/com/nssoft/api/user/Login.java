package com.nssoft.api.user;

import java.io.IOException;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.neighborsystem.durian.exception.AbsException;
import com.neighborsystem.durian.restapi.api.HttpMethod;
import com.nssoft.controller.AbsQuery;
import com.nssoft.exception.AuthFailException;
import com.nssoft.model.Success;
import com.nssoft.util.RequestUtil;

/**
 *
 * @ClassName Login
 * @Description Copyright (c) 2014 by NS Soft.
 * @author xuliguo
 * @date 2015年7月24日 上午9:20:21
 * @version V1.0
 * 
 */
@SuppressWarnings({"unused", "rawtypes"})
@Controller("/v1/api/user/login.json")
public class Login extends AbsQuery<Success> {

	private static final Logger logger = Logger.getLogger(Login.class);

	@Override
	public Success executeAPI(HttpServletRequest req,
			HttpServletResponse res, String arg2) throws AbsException {
		String resultPageURL = InternalResourceViewResolver.FORWARD_URL_PREFIX + "/";
		String username = req.getParameter(MustParam.username.name());
		String password = req.getParameter(MustParam.password.name());
		// 获取HttpSession中的验证码
		/*String verifyCode = (String) request.getSession().getAttribute(
				"verifyCode");
		// 获取用户请求表单中输入的验证码
		String submitCode = WebUtils.getCleanParam(request, "verifyCode");
		System.out.println("用户[" + username + "]登录时输入的验证码为[" + submitCode
				+ "],HttpSession中的验证码为[" + verifyCode + "]");
		if (StringUtils.isEmpty(submitCode)
				|| !StringUtils.equals(verifyCode, submitCode.toLowerCase())) {
			request.setAttribute("message_login", "验证码不正确");
			return resultPageURL;
		}*/
		UsernamePasswordToken token = new UsernamePasswordToken(username,
				password);
		token.setRememberMe(true);

		if (logger.isDebugEnabled())
			logger.debug("为了验证登录用户而封装的token为"
					+ ReflectionToStringBuilder.toString(token,
							ToStringStyle.MULTI_LINE_STYLE));

		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		try {
			
			if (logger.isDebugEnabled())
				logger.debug("对用户[" + username + "]进行登录验证..验证开始");

			currentUser.login(token);

			if (logger.isDebugEnabled())
				logger.debug("对用户[" + username + "]进行登录验证..验证通过");

			resultPageURL = "index.html";
			
		} catch (UnknownAccountException e) {
			logger.error(e);
			throw new AuthFailException("未知账户");
		} catch (IncorrectCredentialsException e) {
			logger.error(e);
			throw new AuthFailException("密码错误");
		} catch (LockedAccountException e) {
			logger.error(e);
			throw new AuthFailException("账户已锁定");
		} catch (ExcessiveAttemptsException e) {
			logger.error(e);
			throw new AuthFailException("用户名或密码错误次数过多");
		} catch (AuthenticationException e) {
			logger.error(e);
			throw new AuthFailException("登录失败");
		}
		
		if (currentUser.isAuthenticated()) {
			boolean isAjaxRequest = RequestUtil.isAjaxRequest(req);
			if (isAjaxRequest) {
				return new Success(true, "登录成功.");
			} else {
				try {
					res.sendRedirect(req.getContextPath() + "/index.html");
				} catch (IOException e) {
					logger.error(e);
				}
			}
			
		} else {
			token.clear();
		}
		return null;
	}

	@Override
	public String getApiId() {
		return "auth_login";
	}

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.POST;
	}

	@Override
	public Class getMustParameter() throws AbsException {
		return MustParam.class;
	}

	@Override
	public Class getOptionParameter() throws AbsException {
		return null;
	}

	private enum MustParam {
		username, password
	}

}
