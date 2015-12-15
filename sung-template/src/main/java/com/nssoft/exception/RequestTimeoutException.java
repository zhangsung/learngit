package com.nssoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.neighborsystem.durian.exception.AbsHttpException;

/**   
 *
 * @ClassName RequestTimeoutException
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午5:06:04    
 * @version V1.0      
 *    
 */
/*
 * Http Status 408
 * 请求超时：我们正在等待服务器的请求超时。
 */
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.REQUEST_TIMEOUT, reason="超时")
public class RequestTimeoutException extends AbsHttpException {
	public RequestTimeoutException(String message) {
		super(message);
	}
}
