package com.casamiel.backstage.commom.emun;

/**
 * @author peigen
 */

public enum ErrorCodeEnum {

    Success(0, "success"),
    ParamEmpty(100, "必选参数为空"),
    ParamError(101, "参数格式错误"),
    FrameError(300, "框架级别错误"),
    SystemError(400, "系统级别错误"),
    UnKnownError(999, "未知错误");


    ErrorCodeEnum(int code, String des) {
        this.code = code;
        this.des = des;
    }

    public int getCode() {
        return code;
    }

    public String getDes() {
        return des;
    }

    private int code;
    private String des;

    @Override
    public String toString() {
        return "ErrorCodeEnum{" +
                "code=" + code +
                ", des='" + des + '\'' +
                '}';
    }
}
