package com.listen.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class StationQuery implements Serializable {

    //页码
    @NotNull
    private int page;

    //每页显示记录数
    @NotNull
    private int pageSize;

    /**
     * 电台唯一标识符
     */
    private String stationuuid;

    private String changeuuid;
    /**
     * 电台名称
     */
    private String name;

    /**
     * 电台标签
     */
    private String tags;

    /**
     * 电台标签
     */
    private Long tagId;
    /**
     * 国家
     */
    private String country;
    /**
     * 国家代码
     */
    private String countrycode;

    /**
     * 州/省
     */
    private String state;
    /**
     * 语言
     */
    private String language;
    /**
     * 语言
     */
    private String languageId;
    /**
     * 语言代码
     */
    private String languagecodes;

}
