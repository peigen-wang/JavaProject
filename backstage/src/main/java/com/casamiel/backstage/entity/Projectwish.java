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
 * 牛轧糖活动祝福
 * </p>
 *
 * @author peigen
 * @since 2020-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Projectwish implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增Id
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    /**
     * 状态  0 未审核 1 审核通过 2 审核不通过
     */
    @TableField("Status")
    private Integer Status;

    /**
     * 留言内容
     */
    @TableField("Description")
    private String Description;

    /**
     * 图片地址
     */
    @TableField("ImageUrl")
    private String ImageUrl;

    /**
     * 发布时间
     */
    @TableField("CreateTime")
    private LocalDateTime CreateTime;

    /**
     * 发布者id
     */
    @TableField("OpenId")
    private String OpenId;


}
