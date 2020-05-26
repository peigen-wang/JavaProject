package com.casamiel.backstage.entity;

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
 * 授权用户信息
 * </p>
 *
 * @author peigen
 * @since 2020-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Wechatuser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增Id
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    /**
     * 发布者id
     */
    @TableField("OpenId")
    private String OpenId;

    /**
     * 昵称
     */
    @TableField("Nickname")
    private String Nickname;

    /**
     * 性别 0 女 1 男
     */
    @TableField("Sex")
    private Integer Sex;

    @TableField("Language")
    private String Language;

    /**
     * 普通用户个人资料填写的城市
     */
    @TableField("City")
    private String City;

    /**
     * 用户个人资料填写的省份
     */
    @TableField("Province")
    private String Province;

    /**
     * 国家，如中国为CN
     */
    @TableField("Country")
    private String Country;

    /**
     * 用户头像
     */
    @TableField("Headimgurl")
    private String Headimgurl;

    /**
     * 用户特权信息，json 数组
     */
    @TableField("Privilege")
    private String Privilege;

    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    @TableField("Unionid")
    private String Unionid;

    /**
     * 创建时间
     */
    @TableField("CreateTime")
    private LocalDateTime CreateTime;


}
