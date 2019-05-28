package com.ofme.blog.mapper;

import com.ofme.blog.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import java.util.List;

/**
 * <p>
 * 用户角色表 Mapper 接口
 * </p>
 *
 * @author y14
 * @since 2019-05-23
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {
    List<UserRole> selectByParam(@Param("pm") Map<String, Object> param);
}
