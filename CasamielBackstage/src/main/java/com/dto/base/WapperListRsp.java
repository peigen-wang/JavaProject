package com.dto.base;

import com.commom.MethodResultBase;

import java.util.Collections;
import java.util.List;

public class WapperListRsp<T> extends BaseModelRsp {

    public WapperListRsp(List<T> data) {
        this.data = data;
    }

    public WapperListRsp(MethodResultBase methodResultBase) {
        super(methodResultBase);
    }

    public WapperListRsp() {
        data = Collections.emptyList();
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    /**
     * 泛型集合
     */
    private List<T> data;
}
