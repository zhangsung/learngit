package com.nssoft.exception;

import org.apache.log4j.Logger;
import com.nssoft.util.Prompt;

/** 
 *  
 * @ClassName ErrorSqlException
 * @Description 
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2014年12月13日 下午9:23:20    
 * @version V1.0        
 *        
 */
@SuppressWarnings("serial")
public class SqlException extends ApiException {
	
	private static final Logger logger = Logger.getLogger(SqlException.class);

	public SqlException() {
		super(Prompt.SQLERROR,COMM_ERR_CODE.ERR_SQL.getErrCode());
	}
	public SqlException(String msg) {
		super(msg,COMM_ERR_CODE.ERR_SQL.getErrCode());
	}
	
	public SqlException(String msg, int errCd) {
		super(msg, errCd);
	}
	
	public SqlException(Exception e) {
		String exceptionName = e.getCause().getClass().getName();
		logger.info("------------------------");
		logger.info(exceptionName);
		logger.info("------------------------");
		switch (exceptionName) {
		case "com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException":
			throw new SqlException(Prompt.SQL_SYNTAX_ERROR, COMM_ERR_CODE.ERR_SYNTA_SQL.getErrCode());
		case "org.springframework.jdbc.CannotGetJdbcConnectionException":
			throw new SqlException(Prompt.SQL_CONNECT_ERROR, COMM_ERR_CODE.ERR_SQL_CONNECT.getErrCode());
		default:
			throw new SqlException();
		}
	}


}
