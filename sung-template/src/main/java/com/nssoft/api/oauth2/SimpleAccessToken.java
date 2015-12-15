package com.nssoft.api.oauth2;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
 * @ClassName AccessToken
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年8月11日 上午12:27:59    
 * @version V1.0      
 *    
 */
@Controller("/v1/api/oauth2/access-token2.json")
public class SimpleAccessToken extends AbsQuery<Success> {
	
	private static final Logger logger = Logger.getLogger(SimpleAccessToken.class);
	@Autowired
    private OAuth2Service oAuth2Service;
	@Override
	public String getApiId() {
		return "oauth2_access-token";
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
			//构建OAuth请求  
		    OAuthTokenRequest oauthRequest = new OAuthTokenRequest(req); 
			if (!oauthRequest.getClientId().equals("client_id") || !oauthRequest.getClientSecret().equals("client_secret")) {  
		        /*OAuthResponse response = OAuthASResponse  
		             .errorResponse(HttpServletResponse.SC_BAD_REQUEST)  
		             .setError(OAuthError.TokenResponse.INVALID_CLIENT)  
		             .setErrorDescription("客户端验证失败，如错误的client_id/client_secret")  
		             .buildJSONMessage();  
		        return new ResponseEntity(response.getBody(), HttpStatus.valueOf(response.getResponseStatus()));  */
				throw new AuthFailException("客户端验证失败.错误的client_id/client_secret");
			}  
			
			String authCode = oauthRequest.getParam(OAuth.OAUTH_CODE);  
		      // 检查验证类型，此处只检查AUTHORIZATION_CODE类型，其他的还有PASSWORD或REFRESH_TOKEN  
		      if (oauthRequest.getParam(OAuth.OAUTH_GRANT_TYPE).equals(  
		         GrantType.AUTHORIZATION_CODE.toString())) {  
		         if (!oAuth2Service.checkAuthCode(authCode)) {  
		            /*OAuthResponse response = OAuthASResponse  
		                .errorResponse(HttpServletResponse.SC_BAD_REQUEST)  
		                .setError(OAuthError.TokenResponse.INVALID_GRANT)  
		                .setErrorDescription("错误的授权码")  
		              .buildJSONMessage();  
		           return new ResponseEntity(  
		             response.getBody(), HttpStatus.valueOf(response.getResponseStatus()));  */
		         }  
		      }  
		      
		      
		      //生成Access Token  
		      OAuthIssuer oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());  
		      final String accessToken = oauthIssuerImpl.accessToken();  
		      oAuth2Service.addAccessToken(accessToken, req.getParameter(MustParam.user_id.name()));
			
		      success.setSuccess(true);
		      success.setMsg("获取成功!");
		      success.setResult(accessToken);
		      
			//session = getSession();
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
		client_secret,
		grant_type,
		code,
		redirect_uri,
		user_id,
		password
	}

}
