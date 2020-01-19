package com.zxl.seckill.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * 秒杀商家表
 */
@TableName("seckill_business")
@Data
public class SeckillBusiness {

    // id
    @TableField("id")
    private Long id;

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

    // 描述
    @TableField("remark")
    private String remark;

    // 记录删除标志 [0]-未删除;[1]-逻辑删除
    @TableField("deleted_flag")
    private String deletedFlag;
}
