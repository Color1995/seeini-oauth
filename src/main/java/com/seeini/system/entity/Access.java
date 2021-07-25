package com.seeini.system.entity;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Access implements Serializable {

    /**
     * 唯一ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 登录地点
     */
    private String location;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 操作系统
     */
    private String loginSystem;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 访问参数
     */
    private String params;

    private static final long serialVersionUID = 1L;
}