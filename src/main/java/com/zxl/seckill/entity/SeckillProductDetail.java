package com.zxl.seckill.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.zxl.seckill.util.BaseModel;
import lombok.Data;

/**
 * 秒杀商品详情表
 */
@TableName("seckill_product_detail")
@Data
public class SeckillProductDetail extends BaseModel {

    // 商品ID
    @TableField("product_id")
    private Long productId;

    // 商家ID
    @TableField("business_id")
    private Long businessId;

    // 商品产地
    @TableField("product_place")
    private String productPlace;

    // 商品名称
    @TableField("product_name")
    private String productName;

    // 商品品牌
    @TableField("product_brand")
    private String productBrand;

    // 商品毛重
    @TableField("product_gross")
    private Float productGross;

    // 商品规格和包装
    @TableField("product_specify")
    private String productSpecify;

    // 商品详解图片地址
    @TableField("product_detail_address")
    private String productDetailAddress;
}
