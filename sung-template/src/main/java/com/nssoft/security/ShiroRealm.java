package com.nssoft.security;

import org.apache.log4j.Logger;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;  
import org.apache.commons.lang3.builder.ToStringStyle;  
import org.apache.ibatis.session.SqlSession;
import org.apache.shiro.SecurityUtils;  
import org.apache.shiro.authc.AuthenticationException;  
import org.apache.shiro.authc.AuthenticationInfo;  
import org.apache.shiro.authc.AuthenticationToken;  
import org.apache.shiro.authc.SimpleAuthenticationInfo;  
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;  
import org.apache.shiro.authz.AuthorizationInfo;  
import org.apache.shiro.authz.SimpleAuthorizationInfo;  
import org.apache.shiro.realm.AuthorizingRealm;  
import org.apache.shiro.session.Session;  
import org.apache.shiro.subject.PrincipalCollection;  
import org.apache.shiro.subject.Subject;  

public class ShiroRealm extends AuthorizingRealm {
	
	private static final Logger logger = Logger.getLogger(ShiroRealm.class);  
	
	@Resource
	private SqlSession sqlSession = null;
	
    @Override  
    //权限认证
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){  
        //获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()  
        String user_id = (String) super.getAvailablePrincipal(principals);  
/*		List<String> roleList = new ArrayList<String>();
		List<String> permissionList = new ArrayList<String>();
		// 从数据库中获取当前登录用户的详细信息
		User user = userService.getByUsername(currentUsername);
		if (null != user) {
			// 实体类User中包含有用户角色的实体类信息
			if (null != user.getRoles() && user.getRoles().size() > 0) {
				// 获取当前登录用户的角色
				for (Role role : user.getRoles()) {
					roleList.add(role.getName());
					// 实体类Role中包含有角色权限的实体类信息
					if (null != role.getPermissions()
							&& role.getPermissions().size() > 0) {
						// 获取权限
						for (Permission pmss : role.getPermissions()) {
							if (!StringUtils.isEmpty(pmss.getPermission())) {
								permissionList.add(pmss.getPermission());
							}
						}
					}
				}
			}
		} else {
			throw new AuthorizationException();
		}
		// 为当前用户设置角色和权限
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		simpleAuthorInfo.addRoles(roleList);
		simpleAuthorInfo.addStringPermissions(permissionList);*/  
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();  
        
        Map map = sqlSession.selectOne("user.getUserById", user_id);
        
        if (map == null)
        		throw new  UnknownAccountException();
        
        simpleAuthorInfo.addRoles((Collection<String>) map.get("roles"));
        
        logger.info(simpleAuthorInfo.getRoles());
        
        return simpleAuthorInfo; 
        
        //若该方法什么都不做直接返回null的话,就会导致任何用户访问/admin/listUser.jsp时都会自动跳转到unauthorizedUrl指定的地址  
        //详见applicationContext.xml中的<bean id="shiroFilter">的配置  
        //return null;  
    }  
  
      
   //登录认证
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {  
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  
        if (logger.isDebugEnabled()) {
        		logger.debug("验证当前Subject时获取到token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        }
        
        Map map = sqlSession.selectOne("user.getUserById", token.getUsername());
        if (map == null)
        		throw new  UnknownAccountException();
        
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(token.getUsername(), map.get("password"), this.getName()); 
        return authcInfo;
    }  
      
      
	private void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}
}  