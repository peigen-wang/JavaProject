package com.casamiel.backstage.dto.rsp;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class MemberToken {

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Integer memberId;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;
    /**
     * 真实名
     */
    @ApiModelProperty(value = "真实名")
    private String realName ;
    /**
     * token集合
     */
    @ApiModelProperty(value = "token集合")
    private List<String> tokenList;
}
