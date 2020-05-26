package com.casamiel.backstage.dto.base;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * 传入基类
 */
@Data
public class BaseModelReq {
    /**
     * 令牌
     */
    @ApiModelProperty("Token令牌")
    @NotNull(message = "token不能为空")
    private String token;

}
