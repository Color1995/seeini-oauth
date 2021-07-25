package com.seeini.common.response;

import com.seeini.common.pageinfo.PageInfo;

/**
 * @Author Vincent
 * @Date 2021/7/13 17:37
 * @Version 1.0
 * @Description
 */
public class ResponseUtil {

    public static ResponseData success(ResponseData data){
        return data;
    }

    /**
     * 默认 success
     * @return
     */
    public static ResponseData success(){
        return new ResponseData();
    }

    public static ResponseData success(Object data){
        return new ResponseData(data);
    }


    /**
     * 使用自定义分页
     * @param data
     * @param pageInfo
     * @return
     */
    public static ResponseData success(Object data, PageInfo pageInfo){
        return new ResponseData(ResponseStatus.SUCCESS, data, pageInfo);
    }

    public static ResponseData success(ResponseStatus responseStatus, Object data, PageInfo pageInfo){
        return new ResponseData(responseStatus, data, pageInfo);
    }

    /**
     * 使用pagehelper插件分页
     * @param pageInfo
     * @return
     */
    public static ResponseData success(com.github.pagehelper.PageInfo pageInfo){
        return new ResponseData(ResponseStatus.SUCCESS, pageInfo);
    }

    /**
     * 使用pagehelper插件分页
     * @param data
     * @param pageInfo
     * @return
     */
    public static ResponseData success(Object data, com.github.pagehelper.PageInfo pageInfo){
        return new ResponseData(ResponseStatus.SUCCESS, data, pageInfo);
    }

    /**
     * 默认 error
     * @return
     */
    public static ResponseData error(){
        return new ResponseData(ResponseStatus.BAD_REQUEST);
    }

    /**
     *
     * @param data 错误详细
     * @return
     */
    public static ResponseData error(Object data){
        return new ResponseData(ResponseStatus.BAD_REQUEST,data);
    }

}
