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
 * 招聘职位表
 * </p>
 *
 * @author peigen
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Recruitjob implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    /**
     * 所属部门
     */
    @TableField("Department")
    private String Department;

    /**
     * 类别 
     */
    @TableField("JobType")
    private Integer JobType;

    /**
     * 工作性质 1 全职 2 兼职 3 实习
     */
    @TableField("JobNature")
    private Integer JobNature;

    /**
     * 职位名称
     */
    @TableField("JobName")
    private String JobName;

    /**
     * 招聘人数
     */
    @TableField("Number")
    private Integer Number;

    /**
     * 城市 
     */
    @TableField("CityId")
    private Integer CityId;

    /**
     * 区
     */
    @TableField("DistrictId")
    private Integer DistrictId;

    /**
     * 详细地址
     */
    @TableField("Address")
    private String Address;

    /**
     * 描述 工作内容 职责  薪资福利等等
     */
    @TableField("Description")
    private String Description;

    /**
     * 简历接受邮箱
     */
    @TableField("EMail")
    private String EMail;

    /**
     * 发布时间
     */
    @TableField("CreateTime")
    private LocalDateTime CreateTime;


}
