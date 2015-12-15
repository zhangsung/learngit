package com.nssoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.neighborsystem.durian.exception.AbsHttpException;

/**   
 *
 * @ClassName ServerInternalException
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午5:06:15    
 * @version V1.0      
 *    
 */
/*
 * Http Status 500
 * 内部服务器错误：无法执行，因为在服务器上的错误的请求
 */
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="内部服务器错误")
public class ServerInternalException extends AbsHttpException {
	public ServerInternalException(String message) {
		super(message);
	}
}
