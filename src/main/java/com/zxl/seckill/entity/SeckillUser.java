package com.zxl.seckill.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.zxl.seckill.util.BaseModel;
import lombok.Data;

/**
 * 秒杀用户表
 */
@TableName("seckill_user")
@Data
public class SeckillUser extends BaseModel {

    // 用户名
    @TableField("user_name")
    private String userName;

    // 用户账户
    @TableField("user_account")
    private String userAccount;

    // 密码
    @TableField("user_password")
    private String userPassword;

    // 姓名
    @TableField("name")
    private String name;

    // 年龄
    @TableField("user_age")
    private Integer userAge;

    // 用户电话
    @TableField("user_num")
    private String userNum;

    // 用户住址
    @TableField("user_address")
    private String userAddress;

    // 用户邮箱
    @TableField("user_mail")
    private String userMail;
}
