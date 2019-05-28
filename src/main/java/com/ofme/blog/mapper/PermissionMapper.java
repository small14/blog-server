package com.ofme.blog.mapper;

import com.ofme.blog.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author y14
 * @since 2019-05-23
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    List<Permission> selectByParam(@Param("pm") Map<String, Object> param);
}
