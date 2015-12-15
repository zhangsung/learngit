package com.nssoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.neighborsystem.durian.exception.AbsHttpException;

/**   
 *
 * @ClassName HeaderExceptoin
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午5:04:36    
 * @version V1.0      
 *    
 */
/*
 * Http Status 417
 * 预测失败：服务器不能满足期望请求标头字段的要求
 */
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.EXPECTATION_FAILED, reason="HTTP Head 缺少必要信息")
public class HeaderExceptoin extends AbsHttpException {
	public HeaderExceptoin(String message) {
		super(message);
	}
}
