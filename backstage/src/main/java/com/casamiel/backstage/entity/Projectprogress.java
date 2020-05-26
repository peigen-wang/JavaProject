package com.casamiel.backstage.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 项目进程
 * </p>
 *
 * @author peigen
 * @since 2020-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Projectprogress implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增Id
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    /**
     * 日均销量
     */
    @TableField("AvgCount")
    private Integer AvgCount;

    /**
     * 累计销量
     */
    @TableField("AllCount")
    private Integer AllCount;

    /**
     * 日均销售金额
     */
    @TableField("AvgAmount")
    private BigDecimal AvgAmount;

    /**
     * 捐赠金额
     */
    @TableField("DonationAmount")
    private BigDecimal DonationAmount;

    /**
     * 累计款项
     */
    @TableField("AllDonation")
    private BigDecimal AllDonation;


}
