package com.listen.vo;

import lombok.Data;

@Data
public class StationLocationVO {
    private Long id;


    /**
     * 电台URL
     */
    private String url;

    /**
     * 电台名称
     */
    private String name;

    /**
     * 纬度
     */
    private Double geoLat;

    /**
     * 经度
     */
    private Double geoLong;
}
