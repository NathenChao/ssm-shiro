package net.wanho.realm;

import net.wanho.pojo.User;
import net.wanho.service.UserServiceI;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/4/23.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceI userServiceI;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        String username = principalCollection.getPrimaryPrincipal().toString();
        System.out.println(username);
        List<String> roles = userServiceI.getRoles(username);
        System.out.println(roles);
        List<String> permissions = userServiceI.getPermissions(username);
        System.out.println(permissions);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roles);
        List<String> permission = new ArrayList<String>();
        for (String s : permissions) {
            if (s != null) {
                permission.add(s);
            }
        }
        simpleAuthorizationInfo.addStringPermissions(permission);


        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());

        User user = userServiceI.getUser(username);

        if (user == null) {
            throw new RuntimeException("用户不存在");
        }


        String newPwd = userServiceI.shiroMD5(password, user.getSalt());

        System.out.println(newPwd);
        System.out.println(user.getPassword());
        if (!newPwd .equals( user.getPassword())) {
            throw new IncorrectCredentialsException("账号或者密码不正确");
        }


        return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
    }
}
