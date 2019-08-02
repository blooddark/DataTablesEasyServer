package com.example.datatablesserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Eddy
 */
@Data
public class User {
    @TableId(type=IdType.AUTO)
    private Long id;
    private String username;
    private Integer gender;
    private String remark;
}
