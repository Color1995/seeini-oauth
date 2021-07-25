package com.seeini.stack.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Guidelines implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
    * 标准名称
    */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
    * 发布人id
    */
    private String publisherId;

    /**
    * 发布人姓名
    */
    private String publisherName;

    /**
    * 发布时间
    */
    private Date publishTime;

    /**
    * 修改时间
    */
    private Date modifyTime;

    /**
    * 是否隐藏，1为隐藏
    */
    private Integer isDelete;

    /**
     * 技术方案选图
     */
    private String url;

}