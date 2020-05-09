package com.dto.base;

import com.commom.MethodResultBase;


public class WapperSingleRsp<T> extends BaseModelRsp {


    public WapperSingleRsp() {

    }

    public WapperSingleRsp(MethodResultBase methodResultBase) {
        super(methodResultBase);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 泛型
     */
    private T data;

}
