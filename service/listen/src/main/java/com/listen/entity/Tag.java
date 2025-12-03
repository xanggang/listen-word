package com.listen.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("tags")
public class Tag implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;
    private int stationcount;
}
