package com.ofme.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ofme.blog.base.controller.BaseController;
import com.ofme.blog.base.exception.OFMException;
import com.ofme.blog.base.http.ResponseModel;
import com.ofme.blog.entity.User;
import com.ofme.blog.service.impl.UserServiceImpl;
import com.ofme.blog.tools.TokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerController extends BaseController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/login")
    public ResponseModel login(@RequestBody User user){
        return setSuccessModel(userService.managerLogin(user));
    }

}
