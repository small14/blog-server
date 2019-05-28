package com.ofme.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ofme.blog.base.entity.BaseEntity;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author y14
 * @since 2019-05-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 邮箱(账号)
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 激活状态(0:未激活，1:激活)
     */
    private Integer activation;

    private Date createTime;

    private Date updateTime;

    private Integer system;


}
