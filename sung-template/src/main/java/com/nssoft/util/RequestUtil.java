package com.nssoft.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nssoft.exception.ConvertException;
import com.nssoft.exception.OperateFileException;
import com.nssoft.exception.ParamException;

/**
 *
 * @ClassName RequestUtil
 * @Description Copyright (c) 2014 by NS Soft.
 * @author xuliguo
 * @date 2014年12月12日 下午8:08:55
 * @version V1.0
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class RequestUtil {

	private static final Logger logger = Logger.getLogger(RequestUtil.class);

	public static Map<Object, Object> getParamMap(HttpServletRequest request) {
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		Enumeration<String> paramNames = request.getParameterNames();
		for (Enumeration<String> e = paramNames; e.hasMoreElements();) {
			Object key = e.nextElement();
			Object value = request.getParameter((String) key);
			if (value != null && !value.equals(""))
				paramMap.put(key, value);
		}
		return paramMap;
	}

	// 转换查询条件时间
	public static void transSearchDate(String TIMETYPE, Map paramMap) {
		String STARTDATE = (String) paramMap.get("startDate");
		String ENDDATE = (String) paramMap.get("endDate");
		String formart = "";
		switch (TIMETYPE) {
		case "HOURLY":
			formart = "yyyy-MM-dd HH";
			break;
		case "DAILY":
			formart = "yyyy-MM-dd";
			break;
		case "MONTHLY":
			formart = "yyyy-MM";
			break;
		default:
			throw new ParamException("日期视图错误");
		}
		SimpleDateFormat df = new SimpleDateFormat(formart);
		Calendar cal = Calendar.getInstance();
		try {
			Date START = df.parse(STARTDATE);
			Date END = df.parse(ENDDATE);
			long temp = END.getTime() - START.getTime();
			if (temp >= 0) {
				switch (TIMETYPE) {
				case "HOURLY":
					cal.setTime(END);
					END = cal.getTime();
					/*
					 * int hours= (int) (temp/3600000); if(hours > 23) throw new
					 * ParamException(); else { cal.setTime(END); END =
					 * cal.getTime(); }
					 */
					break;
				case "DAILY":
					cal.setTime(END);
					cal.add(Calendar.DATE, 1);
					END = cal.getTime();
					/*
					 * long days = temp/3600000/24; if(days > 29) throw new
					 * ParamException(); else { cal.setTime(END);
					 * cal.add(Calendar.DATE, 1); END = cal.getTime(); }
					 */
					break;
				case "MONTHLY":
					cal.setTime(END);
					cal.add(Calendar.MONTH, 1);
					END = cal.getTime();
					/*
					 * cal.setTime(START); cal.add(Calendar.MONTH, 23); Date
					 * endMax = cal.getTime(); long months = endMax.getTime() -
					 * END.getTime(); if(months < 0) throw new ParamException();
					 * else { cal.setTime(END); cal.add(Calendar.MONTH, 1); END
					 * = cal.getTime(); }
					 */
					break;
				default:
					throw new ParamException("日期视图错误");
				}
			} else {
				throw new ParamException("开始和结束日期不可相同");
			}
			paramMap.put("startDate", df.format(START));
			paramMap.put("endDate", df.format(END));
		} catch (Exception e) {
			throw new ParamException("日期格式错误");
		}
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = "无法获取IP地址";
		}
		if (ip.equals("0:0:0:0:0:0:0:1"))
			ip = "localhost";
		return ip;
	}

	public static void decodeParams(Map paramMap) {
		Set<String> keySet = paramMap.keySet();
		Iterator<String> itr = keySet.iterator();
		while (itr.hasNext()) {
			String key = itr.next();
			String value = (String) paramMap.get(key);
			try {
				paramMap.put(key, new String(value.getBytes("iso-8859-1"), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				logger.error(e);
				throw new ConvertException("编码转换错误:无法将" + key + "->" + value + "转成utf-8");
			}
		}
	}

	public static String requestURL(String url, Map params, String method) {
		HttpClient client = new DefaultHttpClient();
		ResponseHandler<String> rh = new BasicResponseHandler();
		try {
			switch (method) {
			case "post":
				HttpPost httpost = new HttpPost(url);
				if (params != null) {
					List<NameValuePair> nvps = new ArrayList<NameValuePair>();
					Set<String> keySet = params.keySet();
					for (String key : keySet) {
						nvps.add(new BasicNameValuePair(key, (String) params.get(key)));
					}
					try {
						httpost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
					} catch (UnsupportedEncodingException e) {
						logger.error(e);
						throw new ConvertException("HTTP POST 设置Entity出错.");
					}
				}
				return client.execute(httpost, rh);
			case "get":
				if (params != null) {
					List<NameValuePair> paramList = convertParam(params);
					url += "?" + URLEncodedUtils.format(paramList, "utf-8");
				}
				HttpGet get = new HttpGet(url);
				return client.execute(get, rh);
			default:
				throw new ParamException("请求方法错误.只支持GET/POST");
			}
		} catch (IOException e) {
			logger.error(e);
			throw new OperateFileException();
		} finally {
			client.getConnectionManager().shutdown();
		}
	}

	public static List<NameValuePair> convertParam(Map params) {
		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		Iterator<String> keys = params.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			paramList.add(new BasicNameValuePair(key, params.get(key).toString()));
		}
		return paramList;
	}

	public static void addCookie(HttpServletResponse response, String path,
			String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath(path);
		if (maxAge > 0)
			cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}

	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}

	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

	public static void deleteCookie (String Cookiename, String path,
			HttpServletResponse response) {
		Cookie cookie = new Cookie(Cookiename, null);
		cookie.setPath(path);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
	public static boolean isAjaxRequest (HttpServletRequest req) {
		String requestType = req.getHeader("X-Requested-With");
        if (requestType != null && requestType.equals("XMLHttpRequest")) {
            return true;
        } else {
            return false;
        }
	}
}
