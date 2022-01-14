package com.seeini.common.request;

import com.seeini.common.pageinfo.PageInfo;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author Color
 * @Date 2021/7/13 18:26
 * @Version 1.0
 * @Description
 */
public class RequestData  {

    @ApiModelProperty(value="数据", position=1)
    private Object data;

    @ApiModelProperty(value="分页信息", position=2)
    private PageInfo pageInfo;

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
}
