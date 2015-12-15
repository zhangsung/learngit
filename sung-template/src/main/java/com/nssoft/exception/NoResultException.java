package com.nssoft.exception;


/** 
 *  
 * @ClassName NoResultException
 * @Description
 * Copyright (c) 2014 by NS Soft.  
 * @author xuliguo   
 * @date 2014年12月13日 下午9:12:58    
 * @version V1.0        
 *        
 */
@SuppressWarnings("serial")
public class NoResultException extends ApiException{
	
	public NoResultException() {
		super("", COMM_ERR_CODE.NO_RESULT.getErrCode());
	}

}
