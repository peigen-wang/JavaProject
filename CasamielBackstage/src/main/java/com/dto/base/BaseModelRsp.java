package com.dto.base;

import com.commom.MethodResultBase;
import com.commom.emun.ErrorCodeEnum;
import com.commom.utils.EnumUtil;
import io.swagger.annotations.ApiModelProperty;

/**
 * 传出基类
 * @author peigen
 */
public class BaseModelRsp {

    public BaseModelRsp(MethodResultBase methodResultBase){
        setCode(methodResultBase.getResultNo());
    }

    public BaseModelRsp(){
        setCode(new MethodResultBase().getResultNo());
    }

    public BaseModelRsp(ErrorCodeEnum codeEnum){
        setCode(codeEnum.getCode());
    }

    public BaseModelRsp(ErrorCodeEnum codeEnum,String errorMsg){
        setCode(codeEnum.getCode());
        if(errorMsg!=null)
        {
            setMsg(errorMsg);
        }
    }

    /**
     * 状态码
     */
    @ApiModelProperty("状态码")
    private int code;
    /**
     * 消息
     */
    @ApiModelProperty("返回值")
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
        this.msg =(String) EnumUtil.getEnumDescriotionByValue(code,ErrorCodeEnum.class);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
