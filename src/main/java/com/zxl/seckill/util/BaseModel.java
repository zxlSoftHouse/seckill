package com.zxl.seckill.util;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;

@Data
public class BaseModel {

    // id
    @TableField("id")
    private Long id;

    // 描述
    @TableField("remark")
    private String remark;

    // 记录删除标志 [0]-未删除;[1]-逻辑删除
    @TableField("deleted_flag")
    private String deletedFlag;
}
