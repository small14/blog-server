package com.ofme.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ofme.blog.base.entity.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色权限
 * </p>
 *
 * @author y14
 * @since 2019-05-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("role_permission")
public class RolePermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色权限ID
     */
    private String rolePermissionId;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 权限ID
     */
    private String permissionId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
