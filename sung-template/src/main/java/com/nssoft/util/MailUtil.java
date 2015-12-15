package com.nssoft.util;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.nssoft.exception.ConvertException;
import com.nssoft.model.MailObj;
import com.nssoft.model.MailTemplateObj;
import com.nssoft.model.Success;


/**   
 *
 * @ClassName MailUtil
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月28日 下午2:31:34    
 * @version V1.0      
 *    
 */
@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
public class MailUtil {
	
	private static final Logger logger = Logger.getLogger(MailUtil.class);

	public static Success sendMail(final MailObj mailObj) {
		logger.info("---------开始发送普通邮件-----------");
		logger.info(mailObj);
		String result = 
			RequestUtil.requestURL(mailObj.getUrl(), new HashMap() {
			{
				put("api_user", mailObj.getApi_user());
				put("api_key", mailObj.getApi_key());
				put("from", mailObj.getFrom());
				put("to", mailObj.getTo());
				put("subject", mailObj.getSubject());
				put("html", mailObj.getHtml());
			}
		}, "post");
		logger.info("-------------发送完毕--------------");
		return getSendResult(result);
	}
	
	public static Success sendMail(final MailTemplateObj mailTemplateObj) {
		logger.info("---------开始发送批量邮件-----------");
		logger.info(mailTemplateObj);
		String result = 
				RequestUtil.requestURL(mailTemplateObj.getUrl(), new HashMap() {
				{
					put("template_invoke_name", mailTemplateObj.getTemplate_invoke_name());
					put("substitution_vars", mailTemplateObj.getSubstitution_vars());
					put("api_user", mailTemplateObj.getApi_user());
					put("api_key", mailTemplateObj.getApi_key());
					put("from", mailTemplateObj.getFrom());
					put("subject", mailTemplateObj.getSubject());
				}
			}, "post");
		logger.info("-------------发送完毕--------------");
		return getSendResult(result);
	}
	
	private static Success getSendResult(String result) {
		try {
       		Map resultMap = SerialUtil.JsonToMap(new JSONObject(result));
       		Success success = new Success();
			success.setSuccess(resultMap.get("message").equals("success"));
			List list = (List) resultMap.get("errors");
			if (list != null && list.size() > 0)
				success.setMsg(list.toString());
			if (success.isSuccess()) 
				success.setMsg("发送成功!");
			return success;
		} catch (JSONException e) {
			logger.error(e);
			throw new ConvertException("JSON转Map出错");
		}
	}
	
}
