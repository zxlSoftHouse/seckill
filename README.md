秒杀相关

目录结构
* 




#表

## 秒杀商品表
* 主键
* 商品id
* 标题
* 商品图片
* 原价格
* 秒杀价格
* 商家id
* 添加日期
* 审核日期
* 审核状态
* 开始时间
* 结束时间
* 秒杀商品数
* 剩余库存数
* 描述

## 秒杀订单表
* 主键
* 秒杀商品id
* 支付金额
* 用户id
* 商家id 
* 创建时间
* 支付时间
* 支付状态
* 收货人
* 收货人地址
* 收货人电话
* 交易流水号

## 秒杀用户表
* 主键
* 用户姓名
* 用户账号
* 用户密码
* 用户姓名
* 用户年龄
* 用户电话
* 用户住址
* 用户邮箱

## 秒杀商家表
* 主键
* 商家名称
* 商家账号
* 商家密码
* 商家经营范围

## 秒杀商品详情表
* 主键
* 商品id 
* 商家id
* 商品产地 
* 商品名称
* 品牌
* 商品毛重
* 规格和包装
* 商品详解图片地址