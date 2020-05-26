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
 * 素材分类表
 * </p>
 *
 * @author peigen
 * @since 2020-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Newstype implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增Id
     */
    @TableId(value = "TypeId", type = IdType.AUTO)
    private Integer TypeId;

    /**
     * 分类名称
     */
    @TableField("TypeName")
    private String TypeName;

    /**
     * 分类编码
     */
    @TableField("TypeCode")
    private String TypeCode;

    /**
     * 父级Id
     */
    @TableField("ParentId")
    private Integer ParentId;

    @TableField("CreateTime")
    private LocalDateTime CreateTime;


}
