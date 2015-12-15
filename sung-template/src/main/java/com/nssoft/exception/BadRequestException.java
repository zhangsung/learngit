package com.nssoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.neighborsystem.durian.exception.AbsHttpException;

/**   
 *
 * @ClassName BadRequestException
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午5:02:52    
 * @version V1.0      
 *    
 */
/*
 * Http Status 400
 */
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="错误的请求")
public class BadRequestException extends AbsHttpException {
	public BadRequestException(String message) {
		super(message);
	}
}
