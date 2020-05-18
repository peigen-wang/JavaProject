package com.casamiel.backstage.backstage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 登录信息表
 * </p>
 *
 * @author peigen
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Token implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    /**
     * 用户id
     */
    @TableField("MemberId")
    private Integer MemberId;

    /**
     * 登录密钥
     */
    @TableField("Token")
    private String Token;

    /**
     * 有效期
     */
    @TableField("ExpireTime")
    private LocalDateTime ExpireTime;

    /**
     * 创建时间
     */
    @TableField("CreateTime")
    private LocalDateTime CreateTime;


}
