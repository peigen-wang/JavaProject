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
 * 
 * </p>
 *
 * @author peigen
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Classify implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    /**
     * 分类名称
     */
    @TableField("Title")
    private String Title;

    /**
     * 类型 1 产品 2  可莎生活分类
     */
    @TableField("Types")
    private Integer Types;

    /**
     * 排序
     */
    @TableField("Sort")
    private Integer Sort;

    /**
     * 图标地址
     */
    @TableField("IconUrl")
    private String IconUrl;

    /**
     * 图标点击后地址
     */
    @TableField("IconClickUrl")
    private String IconClickUrl;

    @TableField("CreateTime")
    private LocalDateTime CreateTime;


}
