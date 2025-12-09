package com.listen.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FuzzyStationQuery {

    //页码
    @NotNull
    private int page;

    //每页显示记录数
    @NotNull
    private int pageSize;

    private String keyword;
}
