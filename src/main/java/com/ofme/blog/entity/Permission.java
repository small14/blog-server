package com.ofme.blog.entity;

import com.ofme.blog.base.entity.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author y14
 * @since 2019-05-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Permission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 权限ID
     */
    private String permissionId;

    /**
     * 权限名
     */
    private String permissionName;

    /**
     * 权限描述
     */
    private String permissionDescription;

    /**
     * 权限编码
     */
    private String permissionCode;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
