package com.listen.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

@Data
public class PageQueryDTO implements Serializable {
    //页码
    @NotNull
    private int page;

    //每页显示记录数
    @NotNull
    private int pageSize;
}
