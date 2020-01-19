package com.zxl.seckill.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * 秒杀用户表
 */
@TableName("seckill_user")
@Data
public class SeckillUser {

    // ID
    @TableField("id")
    private Long id;

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

    // 描述
    @TableField("remark")
    private String remark;

    // 记录删除标志 [0]-未删除;[1]-逻辑删除
    @TableField("deleted_flag")
    private String deletedFlag;
}
