package com.ofme.blog.service.impl;

import com.ofme.blog.entity.Role;
import com.ofme.blog.mapper.RoleMapper;
import com.ofme.blog.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author y14
 * @since 2019-05-23
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
