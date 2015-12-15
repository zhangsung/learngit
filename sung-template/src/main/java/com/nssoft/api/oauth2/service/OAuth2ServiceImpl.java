package com.nssoft.api.oauth2.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

/**   
 *
 * @ClassName OAuth2ServiceImpl
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年8月11日 上午12:39:58    
 * @version V1.0      
 *    
 */
@Service
public class OAuth2ServiceImpl implements OAuth2Service {

	private Cache cache;
	
//	@Autowired
//    public OAuth2ServiceImpl(CacheManager cacheManager) {
//        this.cache = cacheManager.getCache("code-cache");
//    }
	
	 @Override
	    public void addAuthCode(String authCode, String username) {
		 cache.put(authCode, username);
	    }

	    @Override
	    public void addAccessToken(String accessToken, String username) {
	        cache.put(accessToken, username);
	    }

	    @Override
	    public String getUsernameByAuthCode(String authCode) {
	        return (String)cache.get(authCode).get();
	    }

	    @Override
	    public String getUsernameByAccessToken(String accessToken) {
	        return (String)cache.get(accessToken).get();
	    }

	    @Override
	    public boolean checkAuthCode(String authCode) {
	    		boolean flag = cache.get(authCode) != null;
//	    		if (flag) 
//	    			cache.evict(authCode);
	        return flag;
	    }

	    @Override
	    public boolean checkAccessToken(String accessToken) {
	        return cache.get(accessToken) != null;
	    }

	    @Override
	    public boolean checkClientId(String clientId) {
	        //return clientService.findByClientId(clientId) != null;
	    		return true;
	    }

	    @Override
	    public boolean checkClientSecret(String clientSecret) {
	        //return clientService.findByClientSecret(clientSecret) != null;
	    		return true;
	    }

	    @Override
	    public long getExpireIn() {
	        return 3600L;
	    }
}
