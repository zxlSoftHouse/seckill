// 秒杀商品表
DROP TABLE IF EXISTS `SECKILL_PRODUCT`;
CREATE TABLE `SECKILL_PRODUCT` (
  `ID` BIGINT(32) NOT NULL DEFAULT '-1' COMMENT 'ID',
  `PRODUCT_TITLE` VARCHAR(32) DEFAULT NULL COMMENT '商品标题',
  `PRODUCT_PICTURE` VARCHAR(32) DEFAULT NULL COMMENT '商品图片',
  `ORIGINAL_PRICE` FLOAT(12,2) DEFAULT 0 COMMENT '原价格',
  `SECKILL_PRICE` FLOAT(12,2) DEFAULT 0 COMMENT '秒杀价格',
  `BUSINESS_ID` BIGINT(32) NOT NULL DEFAULT '-1' COMMENT '商家ID',
  `ADDING_TIME` datetime DEFAULT NULL COMMENT '添加时间',
  `CHECKING_TIME` datetime DEFAULT NULL COMMENT '审核时间',
  `CHECKING_STATUS` CHAR(1) DEFAULT '1' COMMENT '审核状态，1-待审核，2-审核通过，3-审核未通过',
  `START_TIME` datetime DEFAULT NULL COMMENT '开始时间',
  `END_TIME` datetime DEFAULT NULL COMMENT '结束时间',
  `SECKILL_NUM` INT DEFAULT 0 COMMENT '秒杀数量',
  `SURPLUS_STOCK` INT DEFAULT 0 COMMENT '剩余库存',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '描述',
  `DELETED_FLAG` char(1) DEFAULT '0' COMMENT '记录删除标志 [0]-未删除;[1]-逻辑删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


// 秒杀订单表
DROP TABLE IF EXISTS `SECKILL_ORDER`;
CREATE TABLE `SECKILL_ORDER` (
  `ID` BIGINT(32) NOT NULL DEFAULT '-1' COMMENT 'ID',
  `PRODUCT_ID` BIGINT(32) NOT NULL DEFAULT '-1' COMMENT '商品ID',
  `PAY_AMOUNT` FLOAT(12,2) DEFAULT 0 COMMENT '支付金额',
  `USER_ID` BIGINT(32) NOT NULL DEFAULT '-1' COMMENT '用户ID',
  `BUSINESS_ID` BIGINT(32) NOT NULL DEFAULT '-1' COMMENT '商家ID',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
  `PAY_TIME` datetime DEFAULT NULL COMMENT '支付时间',
  `PAY_STATUS` CHAR(1) DEFAULT '1' COMMENT '审核状态，1-待支付，2-已支付，3-取消支付',
  `RECEIVER` VARCHAR(32) DEFAULT NULL COMMENT '收货人',
  `RECEIVER_ADDRESS` VARCHAR(64) DEFAULT NULL COMMENT '收货人地址',
  `RECEIVER_NUM` VARCHAR(32) DEFAULT NULL COMMENT '收货人电话',
  `SERIAL_NUM` VARCHAR(32) DEFAULT NULL COMMENT '交易流水号',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '描述',
  `DELETED_FLAG` char(1) DEFAULT '0' COMMENT '记录删除标志 [0]-未删除;[1]-逻辑删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

// 秒杀用户表
DROP TABLE IF EXISTS `SECKILL_USER`;
CREATE TABLE `SECKILL_USER` (
  `ID` BIGINT(32) NOT NULL DEFAULT '-1' COMMENT 'ID',
  `USER_NAME` VARCHAR(32) DEFAULT NULL COMMENT '用户名',
  `USER_ACCOUNT` VARCHAR(32) DEFAULT NULL COMMENT '用户账户',
  `USER_PASSWORD` VARCHAR(32) DEFAULT NULL COMMENT '密码',
  `NAME` VARCHAR(32) DEFAULT NULL COMMENT '姓名',
  `USER_AGE` INT DEFAULT 0 COMMENT '年龄',
  `USER_NUM` VARCHAR(32) DEFAULT NULL COMMENT '用户电话',
  `USER_ADDRESS` VARCHAR(64) DEFAULT NULL COMMENT '用户住址',
  `USER_MAIL` VARCHAR(32) DEFAULT NULL COMMENT '用户邮箱',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '描述',
  `DELETED_FLAG` char(1) DEFAULT '0' COMMENT '记录删除标志 [0]-未删除;[1]-逻辑删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

// 秒杀商家表
DROP TABLE IF EXISTS `SECKILL_BUSINESS`;
CREATE TABLE `SECKILL_BUSINESS` (
  `ID` BIGINT(32) NOT NULL DEFAULT '-1' COMMENT 'ID',
  `BUSINESS_NAME` VARCHAR(32) DEFAULT NULL COMMENT '商户名称',
  `BUSINESS_ACCOUNT` VARCHAR(32) DEFAULT NULL COMMENT '商户账户',
  `BUSINESS_PASSWORD` VARCHAR(32) DEFAULT NULL COMMENT '用户密码',
  `BUSINESS_SCOPE` varchar(500) DEFAULT NULL COMMENT '商家经营范围',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '描述',
  `DELETED_FLAG` char(1) DEFAULT '0' COMMENT '记录删除标志 [0]-未删除;[1]-逻辑删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


// 秒杀商品详情表
DROP TABLE IF EXISTS `SECKILL_PRODUCT_DETAIL`;
CREATE TABLE `SECKILL_PRODUCT_DETAIL` (
  `ID` BIGINT(32) NOT NULL DEFAULT '-1' COMMENT 'ID',
  `PRODUCT_ID` BIGINT(32) NOT NULL DEFAULT '-1' COMMENT '商品ID',
  `BUSINESS_ID` BIGINT(32) NOT NULL DEFAULT '-1' COMMENT '商家ID',
  `PRODUCT_PLACE` VARCHAR(32) DEFAULT NULL COMMENT '商品产地',
  `PRODUCT_NAME` VARCHAR(64) DEFAULT NULL COMMENT '商品名称',
  `PRODUCT_BRAND` VARCHAR(32) DEFAULT NULL COMMENT '商品品牌',
  `PRODUCT_GROSS` FLOAT(12,2) DEFAULT 0 COMMENT '商品毛重',
  `PRODUCT_SPECIFY` VARCHAR(32) DEFAULT NULL COMMENT '商品规格和包装',
  `PRODUCT_DETAIL_ADDRESS` VARCHAR(32) DEFAULT NULL COMMENT '商品详解图片地址',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '描述',
  `DELETED_FLAG` char(1) DEFAULT '0' COMMENT '记录删除标志 [0]-未删除;[1]-逻辑删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;