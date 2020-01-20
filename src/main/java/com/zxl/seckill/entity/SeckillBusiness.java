package com.zxl.seckill.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.zxl.seckill.util.BaseModel;
import lombok.Data;

/**
 * 秒杀商家表
 */
@TableName("seckill_business")
@Data
public class SeckillBusiness extends BaseModel {

    // 商户名称
    @TableField("business_name")
    private String businessName;

    // 商户账户
    @TableField("business_account")
    private String businessAccount;

    // 用户密码
    @TableField("business_password")
    private String businessPassword;

    // 商家经营范围
    @TableField("business_scope")
    private String businessScope;
}
