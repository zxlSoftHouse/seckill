package com.zxl.seckill.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 秒杀商品表
 */
@TableName("seckill_product")
@Data
public class SeckillProduct {

    // ID
    @TableField("id")
    private Long id;

    // 商品标题
    @TableField("product_title")
    private String productTitle;

    // 商品图片
    @TableField("product_picture")
    private String productPicture;

    // 原价格
    @TableField("original_price")
    private Float originalPrice;

    // 秒杀价格
    @TableField("seckill_price")
    private Float seckillPrice;

    // 商家ID
    @TableField("business_id")
    private Long businessId;

    // 添加时间
    @TableField("adding_time")
    private Date addingTime;

    // 审核时间
    @TableField("checking_time")
    private Date checkingTime;

    // 审核状态，1-待审核，2-审核通过，3-审核未通过
    @TableField("checking_status")
    private String checkingStatus;

    // 开始时间
    @TableField("start_time")
    private Date startTime;

    // 结束时间
    @TableField("end_time")
    private Date endTime;

    // 秒杀数量
    @TableField("seckill_num")
    private Integer seckillNum;

    // 剩余库存
    @TableField("surplus_stock")
    private Integer surplusStock;

    // 描述
    @TableField("remark")
    private String remark;

    // 记录删除标志 [0]-未删除;[1]-逻辑删除
    @TableField("deleted_flag")
    private String deletedFlag;
}
