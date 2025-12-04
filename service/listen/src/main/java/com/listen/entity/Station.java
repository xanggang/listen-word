package com.listen.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import com.common.result.PageResult;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
/**
 * 电台实体类(Station)实体类
 *
 * @author makejava
 * @since 2025-12-04 16:07:09
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("station")
public class Station implements Serializable {
    private static final long serialVersionUID = 268957702176842178L;
    
    /**
     * 主键
     */     
     @TableId(type = IdType.AUTO)
     private Long id;
     

/**
     * 电台变更唯一标识符
     */     
     private String changeuuid;
     
/**
     * 电台唯一标识符
     */     
     private String stationuuid;
     
/**
     * 电台名称
     */     
     private String name;
     
/**
     * 电台URL
     */     
     private String url;
     
/**
     * 解析后的电台URL
     */     
     private String urlResolved;
     
/**
     * 电台主页
     */     
     private String homepage;
     
/**
     * 电台图标
     */     
     private String favicon;
     
/**
     * 电台标签
     */     
     private String tags;
     
/**
     * 国家
     */     
     private String country;
     
/**
     * 国家代码
     */     
     private String countrycode;
     
/**
     * ISO 3166-2国家地区代码
     */     
     private String iso_3166_2;
     
/**
     * 州/省
     */     
     private String state;
     
/**
     * 语言
     */     
     private String language;
     
/**
     * 语言代码
     */     
     private String languagecodes;
     
/**
     * 投票数
     */     
     private Integer votes;
     
/**
     * 最后变更时间
     */     
     private Date lastchangetime;
     
/**
     * 最后变更时间(ISO8601格式)
     */     
     private Date lastchangetimeIso8601;
     
/**
     * 音频编码格式
     */     
     private String codec;
     
/**
     * 比特率
     */     
     private Integer bitrate;
     
/**
     * 是否支持HLS流媒体
     */     
     private Integer hls;
     
/**
     * 最后检查是否成功
     */     
     private Integer lastcheckok;
     
/**
     * 最后检查时间
     */     
     private Date lastchecktime;
     
/**
     * 最后检查时间(ISO8601格式)
     */     
     private Date lastchecktimeIso8601;
     
/**
     * 最后检查成功时间
     */     
     private Date lastcheckoktime;
     
/**
     * 最后检查成功时间(ISO8601格式)
     */     
     private Date lastcheckoktimeIso8601;
     
/**
     * 最后本地检查时间
     */     
     private Date lastlocalchecktime;
     
/**
     * 最后本地检查时间(ISO8601格式)
     */     
     private Date lastlocalchecktimeIso8601;
     
/**
     * 点击时间戳
     */     
     private Date clicktimestamp;
     
/**
     * 点击时间戳(ISO8601格式)
     */     
     private Date clicktimestampIso8601;
     
/**
     * 点击次数
     */     
     private Integer clickcount;
     
/**
     * 点击趋势
     */     
     private Integer clicktrend;
     
/**
     * SSL错误
     */     
     private Integer sslError;
     
/**
     * 纬度
     */     
     private Double geoLat;
     
/**
     * 经度
     */     
     private Double geoLong;
     
/**
     * 距离
     */     
     private Double geoDistance;
     
/**
     * 是否有扩展信息
     */     
     private Integer hasExtendedInfo;
}
