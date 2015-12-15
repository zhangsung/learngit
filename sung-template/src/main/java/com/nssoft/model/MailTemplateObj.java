package com.nssoft.model;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.nssoft.exception.ApiException;

/**   
 *
 * @ClassName MailTemplateObj
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午2:32:36    
 * @version V1.0      
 *    
 */
@SuppressWarnings("rawtypes")
public class MailTemplateObj {
	
	private static final Logger logger = Logger.getLogger(MailTemplateObj.class);
	
	private String url = "https://sendcloud.sohu.com/webapi/mail.send_template.json";
	private String template_invoke_name = "";
	private String substitution_vars = "";
	private String api_user = "";
	private String api_key = "";
	private String from = "";
	private String subject = "";
	
	public String getTemplate_invoke_name() {
		return template_invoke_name;
	}
	public void setTemplate_invoke_name(String template_invoke_name) {
		this.template_invoke_name = template_invoke_name;
	}
	public String getSubstitution_vars() {
		return substitution_vars;
	}
	public void setSubstitution_vars(String to, Map sub) {
		SubstitutionVars temp = new SubstitutionVars();
		temp.setTo(to);
		temp.setSub(sub);
		this.substitution_vars = temp.toString();
	}
	public void setSubstitution_vars(String[] to, Map sub) {
		SubstitutionVars temp = new SubstitutionVars();
		temp.setTo(to);
		temp.setSub(sub);
		this.substitution_vars = temp.toString();
	}
	public void setSubstitution_vars(SubstitutionVars substitution_vars) {
		this.substitution_vars = substitution_vars.toString();
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
			String api_user_batch = props.getProperty("Globals.Config.mail.api_user_batch");
			setApi_user(api_user_batch);
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public MailTemplateObj() {
		try {
			ClassPathResource resource = new ClassPathResource("/globals.properties");
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			String api_user = props.getProperty("Globals.Config.mail.api_user");
			String api_key = props.getProperty("Globals.Config.mail.api_key");
			String from = props.getProperty("Globals.Config.mail.from");
			String template_url = props.getProperty("Globals.Config.mail.template_url");
			this.api_user = api_user;
			this.api_key = api_key;
			this.from = from;
			this.url = template_url;
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
	public MailTemplateObj(String url, String template_invoke_name,
			SubstitutionVars substitution_vars, String api_user, String api_key,
			String from, String subject) {
		this.url = url;
		this.template_invoke_name = template_invoke_name;
		this.substitution_vars = substitution_vars.toString();
		this.api_user = api_user;
		this.api_key = api_key;
		this.from = from;
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "MailTemplateObj\n[\n\turl=" + url + ",\n\ttemplate_invoke_name="
				+ template_invoke_name + ",\n\tsubstitution_vars="
				+ substitution_vars + ",\n\tapi_user=" + api_user + ",\n\tapi_key="
				+ api_key + ",\n\tfrom=" + from + ",\n\tsubject=" + subject + "\n]";
	}
	
	
}
