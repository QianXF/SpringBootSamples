package com.qianxuefeng.spring.shiro;

import com.qianxuefeng.spring.dao.TestUserMapper;
import com.qianxuefeng.spring.domain.TestUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 钱雪峰
 * @since 2016年11月18日
 */
@Component
public class UserRealm extends AuthorizingRealm {
	@Autowired
	private TestUserMapper userMapper;

//	@Autowired
//	private RoleDao roleDao;
//	@Autowired
//	private PermissionDao permissionDao;
//	// @Autowired
//	// private PasswordService passwordService;
//
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		TestUser user = (TestUser) principals.getPrimaryPrincipal();

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

//		List<String> roleList = roleDao.findRolesByUser(user.getId());
//		Set<String> roles = new HashSet<String>(roleList);
//		authorizationInfo.setRoles(roles);
//
//		List<String> permissionList = permissionDao.findPermissionsByUser(user.getId());
//		Set<String> permissions = new HashSet<String>(permissionList);
//		authorizationInfo.setStringPermissions(permissions);

		return authorizationInfo;
	}
	
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String username = token.getUsername();
		char[] password = token.getPassword();
		TestUser user = null;
		// 判断是否填写用户名／密码
		if(StringUtils.isNotBlank(username) && password != null){
			user = userMapper.findByAccount(username);
		}
		
		if (user == null) {
			 throw new UnknownAccountException();//没找到帐号  
		}
		
		return new SimpleAuthenticationInfo(user, user.getPassword(), user.getAccount());
	}

	private static final String OR_OPERATOR = " or ";
	private static final String AND_OPERATOR = " and ";
	private static final String NOT_OPERATOR = "not ";
	/**
	 * 支持or and not 关键词  不支持and or混用
	 * @param principals
	 * @param permission
	 * @return
	 */
	public boolean isPermitted(PrincipalCollection principals, String permission) {
		if(permission.contains(OR_OPERATOR)) {
			String[] permissions = permission.split(OR_OPERATOR);
			for(String orPermission : permissions) {
				if(isPermittedWithNotOperator(principals, orPermission)) {
					return true;
				}
			}
			return false;
		} else if(permission.contains(AND_OPERATOR)) {
			String[] permissions = permission.split(AND_OPERATOR);
			for(String orPermission : permissions) {
				if(!isPermittedWithNotOperator(principals, orPermission)) {
					return false;
				}
			}
			return true;
		} else {
			return isPermittedWithNotOperator(principals, permission);
		}
	}

	private boolean isPermittedWithNotOperator(PrincipalCollection principals, String permission) {
		if(permission.startsWith(NOT_OPERATOR)) {
			return !super.isPermitted(principals, permission.substring(NOT_OPERATOR.length()));
		} else {
			return super.isPermitted(principals, permission);
		}
	}
}
