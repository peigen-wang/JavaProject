package com.commom;

import com.commom.emun.ErrorCodeEnum;

/**
 * @author peigen
 */
public class MethodResultFull<T> extends MethodResultBase {

    /**
     * 泛型值
     */
    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public MethodResultFull(){
        super();
    }

    public MethodResultFull(ErrorCodeEnum codeEnum){
        super(codeEnum);
    }

    public MethodResultFull(MethodResultBase methodResultBase){
        super(methodResultBase);
    }

    public MethodResultFull(T defaultValue){
        super();
        setContent(defaultValue);
    }

    public MethodResultFull(ErrorCodeEnum codeEnum,T defaultValue){
        setContent(defaultValue);
    }

    @Override
    public boolean isSuccess() {
        return super.isSuccess() && this.content!=null;
    }
}
