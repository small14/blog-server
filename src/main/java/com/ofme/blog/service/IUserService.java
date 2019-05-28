package com.ofme.blog.service;

import com.ofme.blog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author y14
 * @since 2019-05-21
 */
public interface IUserService extends IService<User> {

    /**
     * 用户注册
     * @param user
     * @return
     */
    Map<String,String> userRegister(User user);

    /**
     * 用户激活
     * @param userId
     * @return
     */
    Map<String,String> userActivation(String userId);

    /**
     * 用户登录
     */
    Map<String,String> userLogin(User user);

    /**
     * 管理员登录
     */
    Map<String,String> managerLogin(User user);
}
