package com.seeini.common.pageinfo;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author Color
 * @Date 2021/7/14 9:34
 * @Version 1.0
 * @Description
 */
public class PageInfo {
    @ApiModelProperty(value="页面下标")
    private Integer pageNum;

    @ApiModelProperty(value="条数/页面")
    private Integer pageSize;

    @ApiModelProperty(value="总页数")
    private Integer totalPages;

    @ApiModelProperty(value="总条数")
    private Long totalRows;

    @ApiModelProperty(value="排序字段")
    private String[] orderArr;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer PageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Long totalRows) {
        this.totalRows = totalRows;
    }

    public String getOrderArr() {
        return StringUtils.join(orderArr,",");
    }

    public void setOrderArr(String[] orderArr) {
        this.orderArr = orderArr;
    }
}