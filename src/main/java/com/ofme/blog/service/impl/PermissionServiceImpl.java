package com.ofme.blog.service.impl;

import com.ofme.blog.entity.Permission;
import com.ofme.blog.mapper.PermissionMapper;
import com.ofme.blog.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author y14
 * @since 2019-05-23
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
