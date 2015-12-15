package com.nssoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.neighborsystem.durian.exception.AbsHttpException;

/**   
 *
 * @ClassName UndefineParameterException
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午5:06:41    
 * @version V1.0      
 *    
 */
/*
 * Http Status 412
 * 预处理失败：服务器不符合要求的请求者规定的先决条件。
 */
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.PRECONDITION_FAILED, reason="所包含未定义的参数")
public class UndefineParameterException extends AbsHttpException {
	public UndefineParameterException(String message) {
		super(message);
	}
}
