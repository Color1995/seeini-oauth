package com.seeini.common.response;

import com.seeini.common.pageinfo.PageInfo;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author Vincent
 * @Date 2021/7/14 14:02
 * @Version 1.0
 * @Description
 */
public class ResponseData<T> {

    @ApiModelProperty(value="状态", position=1)
    private Integer code;

    @ApiModelProperty(value="消息", position=2)
    private String msg;

    @ApiModelProperty(value="数据", position=3)
    private T data;

    @ApiModelProperty(value="分页", position=4)
    private PageInfo pageInfo;

    public ResponseData() {
//        this.code = ResponseStatus.OK.code();
//        this.msg = ResponseStatus.OK.msg();
//        this.pageInfo = new PageInfo();
    }

    public ResponseData(T data) {
//        this.code = code;
//        this.msg = msg;
        this.data=data;
    }

    public ResponseData(ResponseStatus status) {
        this.code = status.getCode();
        this.msg = status.getMsg();
    }


//    public ResponseData(Integer code, String msg) {
//        this.code = code;
//        this.msg = msg;
//    }

    public ResponseData(ResponseStatus status, T data) {
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.data = data;
    }

    public ResponseData(ResponseStatus status, T data, PageInfo pageInfo) {
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.data = data;
        this.pageInfo = pageInfo;
    }

    public ResponseData(ResponseStatus status, com.github.pagehelper.PageInfo pageInfo) {
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.data=(T) pageInfo.getList();
        this.pageInfo=pagehelper2PageInfo(pageInfo);
    }

    public ResponseData(ResponseStatus status, T data, com.github.pagehelper.PageInfo pageInfo) {
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
        pageInfoVO.setPageRows(pageInfo.getPageSize());
        return pageInfoVO;
    }
}
