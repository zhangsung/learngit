package com.nssoft.exception;

import com.nssoft.util.Prompt;

/** 
 *  
 * @ClassName: AuthFailException
 * @Description： 
 *   
 * @author xuliguo   
 * @date：2014年12月13日 下午9:30:26    
 * @version V1.0        
 *        
 */
@SuppressWarnings("serial")
public class AuthFailException extends ApiException {

	public AuthFailException() {
		super(Prompt.AUTHFAIL,COMM_ERR_CODE.AUTH_FAILE.getErrCode());
	}
	public AuthFailException(String msg) {
		super(msg,COMM_ERR_CODE.AUTH_FAILE.getErrCode());
	}

}
