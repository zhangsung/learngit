package com.nssoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.neighborsystem.durian.exception.AbsHttpException;

/**   
 *
 * @ClassName UnauthorizedException
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午5:06:31    
 * @version V1.0      
 *    
 */
/*
 * Http Status 401
 * 禁止访问：该请求需要身份验证。该服务器可以提供用于一个页面的请求需要登录。
 */
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="没有权限")
public class UnauthorizedException extends AbsHttpException {
	public UnauthorizedException(String message) {
		super(message);
	}
}
