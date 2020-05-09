package com.commom;

import java.util.List;

/**
 * @author peigen
 */
public class PagingResult<T> extends MethodResultBase {

    public PagingResult() {

    }

    public PagingResult(int pageIndex, int pageSize, int total, List<T> list) {
        setPageIndex(pageIndex);
        setPageSize(pageSize);
        setTotal(total);
        setData(list);
    }

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


}
