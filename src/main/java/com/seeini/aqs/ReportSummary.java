package com.seeini.aqs;

import java.io.Serializable;
import java.util.Date;

public class ReportSummary implements Serializable {
    /**
     * 主键ID
     */
    private Integer summaryId;

    /**
     * 字段标题
     */
    private String fieldTitle;

    /**
     * 字段编码
     */
    private String fieldCode;

    /**
     * 报表ID
     */
    private Integer reportId;

    /**
     * 1:有效 0:无效
     */
    private Integer isActive;

    /**
     * 表达式Json对象
     */
    private String expressionValue;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 排序序号
     */
    private Integer sortIndex;

    private static final long serialVersionUID = 1L;

    public Integer getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(Integer summaryId) {
        this.summaryId = summaryId;
    }

    public String getFieldTitle() {
        return fieldTitle;
    }

    public void setFieldTitle(String fieldTitle) {
        this.fieldTitle = fieldTitle;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getExpressionValue() {
        return expressionValue;
    }

    public void setExpressionValue(String expressionValue) {
        this.expressionValue = expressionValue;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }
}

