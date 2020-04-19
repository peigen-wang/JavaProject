package com.dto.base;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 传入基类
 */
public class BaseModelReq {
    /**
     * 令牌
     */
    @ApiModelProperty("Token令牌")
    @NotNull(message = "token不能为空")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
