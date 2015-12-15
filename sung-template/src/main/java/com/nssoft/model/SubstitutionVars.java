package com.nssoft.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

/**   
 *
 * @ClassName SubstitutionVars
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月29日 上午10:10:37    
 * @version V1.0      
 *    
 */
@SuppressWarnings( {"rawtypes", "unchecked"})
public class SubstitutionVars {
	private String[] to = null;
	private Map sub = null;
	
	public String[] getTo() {
		return to;
	}
	public void setTo(String[] to) {
		this.to = to;
	}
	public void setTo(String to) {
		this.to = to.split(";");
	}
	public Map<String, List<String>> getSub() {
		return sub;
	}
	public void setSub(Map sub) {
		Set<String> keySet = sub.keySet();  
        for (String key : keySet) {  
        		Object object = sub.get(key);
        		if (object.getClass() == String.class) {
        			String[] temp = ((String) object).split(";");
        			sub.put(key, Arrays.asList(temp));
			}
        }  
		this.sub = sub;
	}
	public SubstitutionVars(String[] to, Map sub) {
		setTo(to);
		setSub(sub);
	}
	public SubstitutionVars(String to, Map sub) {
		setTo(to);
		setSub(sub);
	}
	public SubstitutionVars() {
		
	}
	
	@Override
	public String toString() {
		return new JSONObject(this).toString();
	}
	
}
