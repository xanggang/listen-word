package com.listen.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("languages")
public class Language implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;
    private String iso_639;
    private int stationcount;
}
