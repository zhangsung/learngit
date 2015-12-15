package com.nssoft.exception;

import com.nssoft.util.Prompt;

/** 
 *  
 * @ClassName ErrorOperateFile
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2014年12月13日 下午9:59:43    
 * @version V1.0        
 *        
 */
@SuppressWarnings("serial")
public class OperateFileException extends ApiException {
	
	public OperateFileException() {
		super(Prompt.IOERROR,COMM_ERR_CODE.ERR_OPERATE_FILE.getErrCode());
	}

	public OperateFileException(String msg) {
		super(msg,COMM_ERR_CODE.ERR_OPERATE_FILE.getErrCode());
	}

}
