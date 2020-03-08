package com.fuhan.account.config;


import com.fuhan.account.entity.Permissions;
import com.fuhan.account.entity.Role;
import com.fuhan.account.entity.User;
import com.fuhan.account.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * @author : FuHan
 * @description : ***
 * @date: 2020/3/7
 */

public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    @Lazy
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String phone = (String) principals.getPrimaryPrincipal();

        User user = userService.findByPhone(phone);

        for (Role role : user.getRoles()) {
            authorizationInfo.addRole(role.getRole());
            for (Permissions permission : role.getPermissions()) {
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String phone = (String) token.getPrincipal();
        User user = userService.findByPhone(phone);

        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()), getName());
    }

}
