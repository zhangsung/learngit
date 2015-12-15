package com.nssoft.exception;

import com.nssoft.util.Prompt;

/** 
 *  
 * @ClassName ParamErrorException
 * @Description 
 * Copyright (c) 2014 by NS Soft.    
 * @author xuliguo   
 * @date 2014年12月13日 下午9:19:46    
 * @version V1.0        
 *        
 */
@SuppressWarnings("serial")
public class ParamException extends ApiException {

	public ParamException() {
		super(Prompt.PARAMERROR,COMM_ERR_CODE.ERR_PARAM.getErrCode());
	}
	public ParamException(String msg) {
		super(msg,COMM_ERR_CODE.ERR_PARAM.getErrCode());
	}

}
