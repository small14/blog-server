package com.ofme.blog.entity;

import com.ofme.blog.base.entity.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author y14
 * @since 2019-05-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色说明
     */
    private String roleDescription;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 是否是注册用户默认角色(0:不是，1:是)
     */
    private Integer defaultRole;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
