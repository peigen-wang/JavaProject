package com.dto.base;

import com.commom.MethodResultBase;
import com.commom.PagingResult;

import java.util.List;

public class PagingRsp<T> extends BaseModelRsp {


    public PagingRsp(MethodResultBase methodResultBase){
        super(methodResultBase);
        PagingResult<T> pagingResult = (PagingResult<T>) methodResultBase;
        if(pagingResult!=null){
            setData(pagingResult.getData());
            setPageIndex(pagingResult.getPageIndex());
            setPageSize(pagingResult.getPageSize());
            setTotal(pagingResult.getTotal());
        }
    }


    /**
     * 索引值
     */
    private int pageIndex;
    /**
     * 页大小
     */
    private int pageSize;
    /**
     * 总数
     */
    private int total;
    /**
     * 泛型集合
     */
    private List<T> data;

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
