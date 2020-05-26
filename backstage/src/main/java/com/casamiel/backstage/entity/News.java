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
 * 素材数据
 * </p>
 *
 * @author peigen
 * @since 2020-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增Id
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    /**
     * 分类Id
     */
    @TableField("TypeId")
    private Integer TypeId;

    /**
     * 分类编码
     */
    @TableField("TypeCode")
    private String TypeCode;

    /**
     * 标题
     */
    @TableField("Title")
    private String Title;

    /**
     * 副标题
     */
    @TableField("SubTitle")
    private String SubTitle;

    /**
     * 简介
     */
    @TableField("Description")
    private String Description;

    /**
     * 图片地址
     */
    @TableField("ImageUrl")
    private String ImageUrl;

    @TableField("CreateTime")
    private LocalDateTime CreateTime;

    /**
     * 活动时间
     */
    @TableField("ActiveTime")
    private String ActiveTime;


}
