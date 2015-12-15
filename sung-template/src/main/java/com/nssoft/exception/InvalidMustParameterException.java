package com.nssoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.neighborsystem.durian.exception.AbsHttpException;

/**   
 *
 * @ClassName InvalidMustParameterException
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午5:04:56    
 * @version V1.0      
 *    
 */
/*
 * Http Status 412
 * 预处理失败：服务器不符合要求的请求者规定的先决条件
 */
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.PRECONDITION_FAILED, reason="缺少必要的参数")
public class InvalidMustParameterException extends AbsHttpException {
	public InvalidMustParameterException(String message) {
		super(message);
	}
}