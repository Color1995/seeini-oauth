package com.seeini.common.response;

import com.seeini.common.pageinfo.PageInfo;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author Color
 * @Date 2021/7/14 14:02
 * @Version 1.0
 * @Description
 */
public class ResponseData {

    @ApiModelProperty(value="状态", position=1)
    private Integer code;

    @ApiModelProperty(value="消息", position=2)
    private String msg;

    @ApiModelProperty(value="数据", position=3)
    private Object data;

    @ApiModelProperty(value="分页", position=4)
    private PageInfo pageInfo;

    public ResponseData() {
        this.code = ResponseStatus.NO_STATUS.getCode();
        this.msg = ResponseStatus.NO_STATUS.getMsg();
//        this.pageInfo = new PageInfo();
    }

    public ResponseData(ResponseStatus status) {
        this.code = status.getCode();
        this.msg = status.getMsg();
    }


    public ResponseData(ResponseStatus status, Object data) {
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.data = data;
    }

    public ResponseData(ResponseStatus status, Object data, PageInfo pageInfo) {
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.data = data;
        this.pageInfo = pageInfo;
    }

    public ResponseData(ResponseStatus status, com.github.pagehelper.PageInfo pageInfo) {
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.data= pageInfo.getList();
        this.pageInfo=pagehelper2PageInfo(pageInfo);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;

    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public void setResponseStatus(ResponseStatus status) {
        this.code = status.getCode();
        this.msg = status.getMsg();
    }

    // pagehelper 转 PageInfo
    private PageInfo pagehelper2PageInfo(com.github.pagehelper.PageInfo pageInfo){

        PageInfo pageInfoVO = new PageInfo();
        pageInfoVO.setTotalRows(pageInfo.getTotal());
        pageInfoVO.setTotalPages(pageInfo.getPages());
        pageInfoVO.setPageNum(pageInfo.getPageNum());
        pageInfoVO.setPageSize(pageInfo.getPageSize());
        return pageInfoVO;
    }
}
