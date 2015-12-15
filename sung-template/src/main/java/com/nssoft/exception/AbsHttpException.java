package com.nssoft.exception;

import com.neighborsystem.durian.exception.AbsException;

/**   
 *
 * @ClassName AbsHttpException
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午5:02:09    
 * @version V1.0      
 *    
 */
@SuppressWarnings("serial")
public abstract class AbsHttpException extends AbsException {
	public AbsHttpException(String message) {
		super(message);
	}
}
