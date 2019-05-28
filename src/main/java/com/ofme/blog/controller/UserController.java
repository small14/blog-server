package com.ofme.blog.controller;


import com.ofme.blog.base.http.ResponseModel;
import com.ofme.blog.entity.User;
import com.ofme.blog.service.impl.UserServiceImpl;
import com.ofme.blog.tools.TokenHelper;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ofme.blog.base.controller.BaseController;

import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author y14
 * @since 2019-05-21
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 注册账号
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ResponseModel userRegister(@RequestBody User user){
        return setSuccessModel(userService.userRegister(user));
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public ResponseModel userLogin(@RequestBody User user){
        try {
            TokenHelper.login(user);
        }catch (Exception e){
            return setFailModel(null);
        }

        return setSuccessModel(null);
    }


    /**
     * 激活
     * @param code
     * @return
     */
    @GetMapping("/activation")
    public ResponseModel userActivation(@RequestParam("code") String code){
        return setSuccessModel(userService.userActivation(code));
    }




//
//    @GetMapping("/testP")
//    @RequiresRoles("1000")
//    public ResponseModel testP(){
//        return setSuccessModel("dadadadadass");
//    }

}

