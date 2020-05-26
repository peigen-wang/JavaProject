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
 * 
 * </p>
 *
 * @author peigen
 * @since 2020-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Content implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    /**
     * 所属分类id
     */
    @TableField("TypeId")
    private Integer TypeId;

    /**
     * 标题
     */
    @TableField("Title")
    private String Title;

    /**
     * 图片地址
     */
    @TableField("ImageUrl")
    private String ImageUrl;

    /**
     * 创建时间
     */
    @TableField("CreateTime")
    private LocalDateTime CreateTime;


}
