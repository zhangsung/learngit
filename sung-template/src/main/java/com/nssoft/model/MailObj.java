package com.nssoft.model;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.nssoft.exception.ApiException;

/**   
 *
 * @ClassName MailObj
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午2:32:19    
 * @version V1.0      
 *    
 */
public class MailObj {
	
	private static final Logger logger = Logger.getLogger(MailObj.class);

	private String url = "https://sendcloud.sohu.com/webapi/mail.send.json";
	private String api_user = null;
	private String api_key = null;
	private String from = null;
	private String to = null;
	private String subject = null;
	private String html = null;
	
	public MailObj() {
		try {
			ClassPathResource resource = new ClassPathResource("/globals.properties");
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			String url = props.getProperty("Globals.Config.mail.url");
			String api_user = props.getProperty("Globals.Config.mail.api_user");
			String api_key = props.getProperty("Globals.Config.mail.api_key");
			String from = props.getProperty("Globals.Config.mail.from");
			this.url = url;
			this.api_user = api_user;
			this.api_key = api_key;
			this.from = from;
		} catch (IOException e) {
			logger.error(e);
			throw new ApiException("SendCloud初始化参数出错");
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getApi_user() {
		return api_user;
	}

	public void setApi_user(String api_user) {
		this.api_user = api_user;
	}
	
	public void setApi_user_batch() {
		try {
			ClassPathResource resource = new ClassPathResource("/globals.properties");
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			String api_user = props.getProperty("Globals.Config.mail.api_user_batch");
			this.api_user = api_user;
		} catch (IOException e) {
			logger.error(e);
			throw new ApiException("SendCloud初始化参数出错");
		}
	}
	
	public String getApi_key() {
		return api_key;
	}

	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public MailObj(String url, String api_user, String api_key, String from,
			String to, String subject, String html) {
		this.url = url;
		this.api_user = api_user;
		this.api_key = api_key;
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.html = html;
	}

	@Override
	public String toString() {
		return "MailObj:\n[\n\turl=" + url + ",\n\tapi_user=" + api_user + ",\n\tapi_key="
				+ api_key + ",\n\tfrom=" + from + ",\n\tto=" + to + ",\n\tsubject="
				+ subject + ",\n\thtml=" + html + "\n]";
	}

}
