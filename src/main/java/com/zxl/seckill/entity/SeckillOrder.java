package com.zxl.seckill.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.zxl.seckill.util.BaseModel;
import lombok.Data;

import java.util.Date;

/**
 * 秒杀订单表
 */
@TableName("seckill_order")
@Data
public class SeckillOrder extends BaseModel {

    // 商品ID
    @TableField("product_id")
    private Long productId;

    // 支付金额
    @TableField("pay_amount")
    private Float payAmount;

    // 用户ID
    @TableField("user_id")
    private Long userId;

    // 商家ID
    @TableField("business_id")
    private Long businessId;

    // 开始时间
    @TableField("create_time")
    private Date createTime;

    // 支付时间
    @TableField("pay_time")
    private Date payTime;

    // 审核状态，1-待支付，2-已支付，3-取消支付
    @TableField("pay_status")
    private String payStatus;

    // 收货人
    @TableField("receiver")
    private String receiver;

    // 收货人地址
    @TableField("receiver_address")
    private String receiverAddress;

    // 收货人电话
    @TableField("receiver_num")
    private String receiverNum;

    // 交易流水号
    @TableField("serial_num")
    private String serialNum;
}
