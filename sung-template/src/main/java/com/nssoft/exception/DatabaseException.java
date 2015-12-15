package com.nssoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.neighborsystem.durian.exception.AbsHttpException;

/**   
 *
 * @ClassName DatabaseException
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午5:03:39    
 * @version V1.0      
 *    
 */
/*
 * Http Status 503
 * 服务不可用：当前服务器不可用，因为服务器超载或停机维护。这通常是一个暂时的状态。
 */
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.SERVICE_UNAVAILABLE, reason="DBMS 错误")
public class DatabaseException extends AbsHttpException {
	public DatabaseException(String message) {
		super(message);
	}
}
