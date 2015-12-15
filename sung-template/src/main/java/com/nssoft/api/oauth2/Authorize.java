package com.nssoft.api.oauth2;

import org.apache.log4j.Logger;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import com.neighborsystem.durian.exception.AbsAPIException;
import com.neighborsystem.durian.exception.AbsException;
import com.neighborsystem.durian.restapi.api.HttpMethod;
import com.nssoft.api.oauth2.service.OAuth2Service;
import com.nssoft.controller.AbsQuery;
import com.nssoft.exception.ApiException;
import com.nssoft.exception.AuthFailException;
import com.nssoft.exception.ParamException;
import com.nssoft.exception.SqlException;
import com.nssoft.model.Success;

/**   
 *
 * @ClassName Authorize
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年8月10日 下午11:58:13    
 * @version V1.0      
 *    
 */
@Controller("/v1/api/oauth2/authorize.json")
public class Authorize extends AbsQuery<Success> {
	
	private static final Logger logger = Logger.getLogger(Authorize.class);
	@Autowired
    private OAuth2Service oAuth2Service;
	@Override
	public String getApiId() {
		return "oauth2_authorize";
	}

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.ALL;
	}

	@Override
	public Success executeAPI(HttpServletRequest req, HttpServletResponse res,
			String trId) throws AbsException {
		SqlSession session = null;
		Success success = new Success(false, "获取鉴权码失败!");
		try {
			//构建OAuth 授权请求  
			OAuthAuthzRequest oauthRequest = new OAuthAuthzRequest(req);  
			if (!oauthRequest.getClientId().equals("client_id")) {  
		        /*OAuthResponse response = OAuthASResponse  
		             .errorResponse(HttpServletResponse.SC_BAD_REQUEST)  
		             .setError(OAuthError.TokenResponse.INVALID_CLIENT)  
		             .setErrorDescription("客户端验证失败，如错误的client_id/client_secret")  
		             .buildJSONMessage();  
		        return new ResponseEntity(response.getBody(), HttpStatus.valueOf(response.getResponseStatus()));  */
				throw new AuthFailException("客户端验证失败.错误的client_id/client_secret");
			}  
			Subject subject = SecurityUtils.getSubject();  
			
		    if (subject.isAuthenticated()) {  
		    		String username = (String)subject.getPrincipal();  
		        //生成授权码  
		        String authorizationCode = null;  
		        //responseType目前仅支持CODE，另外还有TOKEN  
		        String responseType = oauthRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);  
		        if (responseType.equals(ResponseType.CODE.toString())) {  
		          OAuthIssuerImpl oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());  
		          authorizationCode = oauthIssuerImpl.authorizationCode();  
		          oAuth2Service.addAuthCode(authorizationCode, username);  
		          success.setSuccess(true);
		          success.setMsg("获取鉴权码成功!");
		          success.setResult(authorizationCode);
		        }  
		    }  
			
			session = getSession();
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
		return success;
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
		client_id,
		response_type,
		redirect_uri
	}
	
	private boolean login(Subject subject, HttpServletRequest request) {
		if ("get".equalsIgnoreCase(request.getMethod())) {
			return false;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			return false;
		}

		UsernamePasswordToken token = new UsernamePasswordToken(username,
				password);
		try {
			subject.login(token);
			return true;
		} catch (Exception e) {
			request.setAttribute("error", "登录失败:" + e.getClass().getName());
			return false;
		}
	}

}
