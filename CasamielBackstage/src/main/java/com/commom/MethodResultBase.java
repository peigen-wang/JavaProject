package com.commom;

import com.commom.emun.ErrorCodeEnum;

/**
 * @author peigen
 */
public class MethodResultBase {

    /**
     * 状态码
     */
    private int resultNo;

    /**
     * 无参构造方法默认成功
     */
    public MethodResultBase() {
        setResultNo(ErrorCodeEnum.Success.getCode());
    }

    /**
     * 请传入错误码
     *
     * @param status
     */
    public MethodResultBase(ErrorCodeEnum status) {
        setResultNo(status.getCode());
    }

    public MethodResultBase(MethodResultBase methodResultBase) {
        this.resultNo = methodResultBase.resultNo;
    }

    public boolean isSuccess() {
        return this.getResultNo() == ErrorCodeEnum.Success.getCode();
    }

    public int getResultNo() {
        return resultNo;
    }

    public void setResultNo(int resultNo) {
        this.resultNo = resultNo;
    }
}
