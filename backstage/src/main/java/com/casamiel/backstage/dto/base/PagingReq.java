package com.casamiel.backstage.dto.base;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;

public class PagingReq extends BaseModelReq {
    /**
     * 当前页索引
     */
    @ApiModelProperty("当前页索引")
    @Min(value = 1, message = "索引不能小于0")
    private int pageIndex;
    /**
     * 每页大小
     */
    @ApiModelProperty("每页大小")
    @Min(value = 1, message = "每页大小不能小于0")
    private int pageSize;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


}
