package com.ofme.blog.mapper;

import com.ofme.blog.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author y14
 * @since 2019-05-21
 */
public interface UserMapper extends BaseMapper<User> {
    List<String> queryUserRoleCodeList(String userId);
}
