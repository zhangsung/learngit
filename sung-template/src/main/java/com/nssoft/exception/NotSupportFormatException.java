package com.nssoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.neighborsystem.durian.exception.AbsHttpException;

/**   
 *
 * @ClassName NotSupportFormatException
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午5:05:52    
 * @version V1.0      
 *    
 */
/*
 * Http Status 406
 * 不允许：请求的页面无法与请求的内容特性响应
 */
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE, reason="格式不支持该请求")
public class NotSupportFormatException extends AbsHttpException {
	public NotSupportFormatException(String message) {
		super(message);
	}
}
