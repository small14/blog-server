package com.ofme.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ofme.blog.base.exception.OFMException;
import com.ofme.blog.entity.User;
import com.ofme.blog.mapper.UserMapper;
import com.ofme.blog.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ofme.blog.tools.EMailHelper;
import com.ofme.blog.tools.LocalDateTimeUtils;
import com.ofme.blog.tools.PropertiesHelper;
import com.ofme.blog.tools.TokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author y14
 * @since 2019-05-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private EMailHelper eMailHelper;
    @Autowired
    private PropertiesHelper propertiesHelper;
    @Value("${server.port}")
    private String port;
    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Override
    public Map<String,String> userRegister(User user) {
        user.setUserId(UUID.randomUUID().toString());
        user.setCreateTime(new Date());
        user.setActivation(0);
        super.getBaseMapper().insert(user);
        String url = propertiesHelper.getParam("project.address.domainName")+":"+port+contextPath+"/user/activation?code="+user.getUserId();
        String mailContent = "<span>请点击下面的链接激活您的账号</span><br/> <a href=\""+url+"\">激活账号</a>";
        eMailHelper.sendMail("OFM注册验证",mailContent,null,user.getEmail());
        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("msg","激活邮件已经发送至您的邮箱，请按照邮件指引激活账号");
        return resultMap;
    }

    @Override
    public Map<String,String> userActivation(String userId) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("userId",userId);
        wrapper.set("activation",1);
        boolean flag = update(wrapper);
        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("msg","激活邮件已经发送至您的邮箱，请按照邮件指引激活账号");
        if (flag){
            resultMap.put("msg","激活成功");
        }else {
            resultMap.put("msg","激活失败");
        }
        return resultMap;

    }


    @Override
    public Map<String,String> userLogin(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email",user.getEmail());
        wrapper.eq("password",user.getPassword());
        User resultUser = getOne(wrapper);

        return null;
    }

    @Override
    public Map<String, String> managerLogin(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email",user.getEmail());
        wrapper.eq("password",user.getPassword());
        wrapper.eq("system","1");
        User resultUser = getOne(wrapper);
        if (null == resultUser){
            throw new OFMException("该用户无法登录管理系统");
        }else {
            TokenHelper.login(user);
            Map<String,String> resultMap = new HashMap<>();
            resultMap.put("msg","登录成功");
        }
        return null;
    }
}
