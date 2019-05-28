package com.ofme.blog.service.impl;

import com.ofme.blog.entity.UserRole;
import com.ofme.blog.mapper.UserRoleMapper;
import com.ofme.blog.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author y14
 * @since 2019-05-23
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
