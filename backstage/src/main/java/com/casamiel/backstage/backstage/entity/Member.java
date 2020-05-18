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
 * 用户信息表
 * </p>
 *
 * @author peigen
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "MemberId", type = IdType.AUTO)
    private Integer MemberId;

    /**
     * 用户名
     */
    @TableField("UserName")
    private String UserName;

    /**
     * 密码
     */
    @TableField("Password")
    private String Password;

    /**
     * 真实姓名
     */
    @TableField("RealName")
    private String RealName;

    /**
     * 手机号
     */
    @TableField("Mobile")
    private String Mobile;

    /**
     * 状态，1有效，11锁定
     */
    @TableField("Status")
    private Integer Status;

    @TableField("CreateTime")
    private LocalDateTime CreateTime;


}
