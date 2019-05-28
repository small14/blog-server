package com.ofme.blog.mapper;

import com.ofme.blog.entity.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import java.util.List;

/**
 * <p>
 * 角色权限 Mapper 接口
 * </p>
 *
 * @author y14
 * @since 2019-05-23
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
    List<RolePermission> selectByParam(@Param("pm") Map<String, Object> param);
}
