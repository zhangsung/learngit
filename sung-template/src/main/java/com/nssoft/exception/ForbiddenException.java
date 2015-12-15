package com.nssoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.neighborsystem.durian.exception.AbsHttpException;

/**   
 *
 * @ClassName ForbiddenException
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午5:04:09    
 * @version V1.0      
 *    
 */
/*
 * Http Status 403
 * 禁止：服务器拒绝了您的请求.
 */
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="禁止")
public class ForbiddenException extends AbsHttpException {
	public ForbiddenException(String message) {
		super(message);
	}
}
