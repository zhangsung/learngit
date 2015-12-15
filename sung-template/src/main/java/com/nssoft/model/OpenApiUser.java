package com.nssoft.model;

import javax.validation.constraints.NotNull;


/**   
 *
 * @ClassName OpenApiUser
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年8月10日 下午4:09:38    
 * @version V1.0      
 *    
 */
public class OpenApiUser {
	@NotNull
	private String api_id;
	@NotNull
	private String api_key;
	@NotNull
	private String api_secret;
	public String getApi_id() {
		return api_id;
	}
	public void setApi_id(String api_id) {
		this.api_id = api_id;
	}
	public String getApi_key() {
		return api_key;
	}
	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}
	public String getApi_secret() {
		return api_secret;
	}
	public void setApi_secret(String api_secret) {
		this.api_secret = api_secret;
	}
	@Override
	public String toString() {
		return "OpenApiUser [api_id=" + api_id + ", api_key=" + api_key
				+ ", api_secret=" + api_secret + "]";
	}
	
	
}
