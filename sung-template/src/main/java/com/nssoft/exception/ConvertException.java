package com.nssoft.exception;

import com.nssoft.util.Prompt;

/** 
 *  
 * @ClassName ErrorConvertException
 * @Description 
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2014年12月13日 下午9:39:44    
 * @version V1.0        
 *        
 */
@SuppressWarnings("serial")
public class ConvertException extends ApiException {

	public ConvertException() {
		super(Prompt.CONVERTERROR,COMM_ERR_CODE.ERR_CONVERT_FAIL.getErrCode());
	}
	public ConvertException(String msg) {
		super(msg,COMM_ERR_CODE.ERR_CONVERT_FAIL.getErrCode());
	}

}
