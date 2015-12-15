package com.nssoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.neighborsystem.durian.exception.AbsHttpException;

/**   
 *
 * @ClassName LinkedSystemException
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午5:05:19    
 * @version V1.0      
 *    
 */
/*
 * Http Status 502
 * 错误的网关：服务器收到网关或代理，或上游服务器的无效响应.
 */
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.BAD_GATEWAY, reason="错误的网关")
public class LinkedSystemException extends AbsHttpException {
	public LinkedSystemException(String message) {
		super(message);
	}
}
