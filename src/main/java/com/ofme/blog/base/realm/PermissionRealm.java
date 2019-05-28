package com.ofme.blog.base.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ofme.blog.entity.User;
import com.ofme.blog.mapper.UserMapper;
import com.ofme.blog.service.impl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

public class PermissionRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserMapper userMapper;


    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(new HashSet<>(userMapper.queryUserRoleCodeList(user.getUserId())));
        return authorizationInfo;
    }

    /**
     * 用户验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email",token.getUsername());
        wrapper.eq("password",String.valueOf(token.getPassword()));
        User user = userService.getOne(wrapper);
        if (null != user){
            return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        }else {
            throw new AccountException("账号或者密码不正确！");
        }
    }
}
