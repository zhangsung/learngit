package com.nssoft.model;
/**   
 *
 * @ClassName Success
 * @Description 操作返回类型 insert update delete 使用.
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2014年10月25日 下午3:12:59    
 * @version V1.0      
 *    
 */
public class Success {
	
	private boolean success = false;
	private String msg = "";
	private Object result = null;
	
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setOptions(boolean success, String msg){
		this.success = success;
		this.msg = msg;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Success() {
	}
	public Success(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}
	public Success(boolean success) {
		this.success = success;
	}
	public Success(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Success [success=" + success + ", msg=" + msg + ", result="
				+ result + "]";
	}
	
}
