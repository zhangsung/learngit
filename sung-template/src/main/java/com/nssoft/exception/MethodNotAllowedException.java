package com.nssoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.neighborsystem.durian.exception.AbsHttpException;

/**   
 *
 * @ClassName MethodNotAllowedException
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午5:05:28    
 * @version V1.0      
 *    
 */
/*
 * Http Status 405
 * 方法不允许：不能用在请求中指定的方法
 */
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.METHOD_NOT_ALLOWED, reason="Method不允许")
public class MethodNotAllowedException extends AbsHttpException {
	public MethodNotAllowedException(String message) {
		super(message);
	}
}
