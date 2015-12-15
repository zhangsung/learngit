package com.nssoft.exception;


import com.neighborsystem.durian.exception.AbsAPIException;
import com.nssoft.util.Prompt;

public class ApiException extends AbsAPIException {
	private static final long serialVersionUID = 1131008660666875779L;
	
	public ApiException() {
		super(Prompt.SERVERERROR, COMM_ERR_CODE.ERR_DEFAULT.getErrCode());
	}
	
	public ApiException(String message, int errCd) {
		super(message, errCd);
	}
	
	public ApiException(String message, int errCd, Throwable t) {
		super(message, errCd, t);
	}
	
	public ApiException(String msg) 
	{
		super(msg, COMM_ERR_CODE.ERR_DEFAULT.getErrCode());
	}
	
	public ApiException(String message, COMM_ERR_CODE parmErrCd) {
		super(message, parmErrCd.getErrCode());
	}
	
	public ApiException(Throwable t) {
		super(Prompt.SERVERERROR, COMM_ERR_CODE.ERR_DEFAULT.getErrCode(), t);
	}	

	public ApiException(COMM_ERR_CODE parmErrCd, Throwable t) {
		super(Prompt.SERVERERROR, parmErrCd.getErrCode(), t);
	}
	
	public enum COMM_ERR_CODE
	{
		SUCCESS				(0)
		,ERR_DEFAULT		(-1)
		, NO_RESULT		(-100)		
		, ERR_PARAM			(-200)
		, ERR_CONVERT_FAIL (-202)
		, ERR_OPERATE_FILE (-203)
		, ERR_SQL			(-400)	
		, ERR_SYNTA_SQL (-401)
		, ERR_SQL_CONNECT (-402)
		, AUTH_FAILE		(-600)
		;
		
		private int intCode;
		
		private COMM_ERR_CODE(int errcode)
		{
			intCode = errcode;
		}
		
		public int getErrCode()
		{
			return intCode;
		}
	}	


}
