package com.seeini.oauth.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @Author Color
 * @Date 2021/7/26 11:42
 * @Version 1.0
 * @Description
 */
@ApiModel(value = "com-seeini-oauth-entity-User")
@Data
public class User implements Serializable {
    @ApiModelProperty(value = "")
    private Integer id;

    @ApiModelProperty(value = "")
    private String account;

    @ApiModelProperty(value = "")
    private String password;

    @ApiModelProperty(value = "")
    private String username;

    @ApiModelProperty(value = "")
    private Integer deptId;

    @ApiModelProperty(value = "")
    private String deptName;

    @ApiModelProperty(value = "")
    private String email;

    @ApiModelProperty(value = "")
    private String mobile;

    /**
     * 状态 0锁定 1有效
     */
    @ApiModelProperty(value = "状态 0锁定 1有效")
    private String status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    /**
     * 最近访问时间
     */
    @ApiModelProperty(value = "最近访问时间")
    private Date lastLoginTime;

    /**
     * 0=男,1=女,2=保密
     */
    @ApiModelProperty(value = "0=男,1=女,2=保密")
    private String sex;

    @ApiModelProperty(value = "")
    private String avatar;

    /**
     * 主题
     */
    @ApiModelProperty(value = "主题")
    private String theme;

    /**
     * 是否开启tab，0关闭 1开启
     */
    @ApiModelProperty(value = "是否开启tab，0关闭 1开启")
    private String isTab;

    @ApiModelProperty(value = "")
    private String description;

    /**
     * token
     */
    @ApiModelProperty(value = "token")
    private String token;

    /**
     * 是否启用token
     */
    @ApiModelProperty(value = "是否启用token")
    private String isusedtk;

    private static final long serialVersionUID = 1L;
}