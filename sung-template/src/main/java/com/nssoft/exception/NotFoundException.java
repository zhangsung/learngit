package com.nssoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.neighborsystem.durian.exception.AbsHttpException;

/**   
 *
 * @ClassName NotFoundException
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午5:05:40    
 * @version V1.0      
 *    
 */
/*
 * Http Status 404
 * 未找到：服务器无法找到您请求的页面。例如，如果存在对于不存在于服务器上的网页的请求时，服务器提供该代码。
 */
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="未发现")
public class NotFoundException extends AbsHttpException {
	public NotFoundException(String message) {
		super(message);
	}
}