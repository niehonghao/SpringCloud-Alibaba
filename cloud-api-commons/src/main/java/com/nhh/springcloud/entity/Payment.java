package com.nhh.springcloud.entity;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * (Payment)表实体类
 *
 * @author makejava
 * @since 2022-11-22 18:55:13
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("payment")
public class Payment {
    @TableId
    private Long id;


    private String serial;
}
