package com.nssoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.neighborsystem.durian.exception.AbsHttpException;

/**   
 *
 * @ClassName InvalidValueException
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午5:05:07    
 * @version V1.0      
 *    
 */
/*
 * Http Status 422
 * 不能被处理的实体
 */
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY, reason="该参数的值是不正确")
public class InvalidValueException extends AbsHttpException {
	public InvalidValueException(String message) {
		super(message);
	}
}
