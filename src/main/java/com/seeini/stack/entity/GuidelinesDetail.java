package com.seeini.stack.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class GuidelinesDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 类别ID
     */
    private Long guidelinesId;

    /**
     * 类别名
     */
    private String guidelinesName;

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

}