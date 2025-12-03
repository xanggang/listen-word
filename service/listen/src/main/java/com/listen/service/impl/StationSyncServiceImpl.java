package com.listen.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.common.utils.HttpClientUtil;
import com.listen.entity.Country;
import com.listen.entity.Language;
import com.listen.entity.Station;
import com.listen.entity.Tag;
import com.listen.mapper.CountriesMapper;
import com.listen.mapper.LanguageMapper;
import com.listen.mapper.StationMapper;
import com.listen.mapper.TagMapper;
import com.listen.service.StationSyncService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.BatchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Writer;
import java.util.List;


/**
 * 三方文档地址: https://fi1.api.radio-browser.info/
 * 电台同步服务实现类
 */
@Slf4j
@Service
public class StationSyncServiceImpl implements StationSyncService {

    @Autowired
    private CountriesMapper countriesMapper;

    @Autowired
    private LanguageMapper languageMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private StationMapper stationMapper;

    // 获取国家列表
    public void getCountrieslist() {
        String json = HttpClientUtil.doGet("http://fi1.api.radio-browser.info/json/countries", null);
        log.info("获取国家列表成功={}", json);

        List<Country> countryList = JSONObject.parseArray(json, Country.class);

        log.info("获取国家列表成功={}", countryList);
        countriesMapper.insert(countryList);
    }

    // 获取语言列表
    public void getLanguageList() {
        String json = HttpClientUtil.doGet("http://fi1.api.radio-browser.info/json/languages", null);
        log.info("获取语言列表={}", json);

        List<Language> languageList = JSONObject.parseArray(json, Language.class);

        log.info("获取语言列表={}", languageList);
        languageMapper.insert(languageList);
    }

    // 获取标签列表
    public void getTagList() {
        String json = HttpClientUtil.doGet("http://fi1.api.radio-browser.info/json/tags", null);
        log.info("获取标签列表={}", json);

        List<Tag> tagList = JSONObject.parseArray(json, Tag.class);

        log.info("获取标签列表={}", tagList);
        tagMapper.insert(tagList);
    }

    // 获取全部电台
    public void getAllStations() {
        String json = HttpClientUtil.doGet("http://fi1.api.radio-browser.info/json/stations", null);
        log.info("获取全部电台={}", json);
        // 将请求到的数据以文本的形式写入resource目录下的station.json文件中
        try {
            String filePath = "src/main/resources/station.json";
            java.io.FileWriter fileWriter = new java.io.FileWriter(filePath);
            fileWriter.write(json);
            fileWriter.close();
            log.info("电台数据已写入文件: {}", filePath);
        } catch (Exception e) {
            log.error("写入电台数据到文件失败", e);
        }

//        List<Station> tagList = JSONObject.parseArray(json, Station.class);
//        log.info("获取全部电台={}", tagList);
//        stationMapper.insert(tagList);
    }

    // 按照批次获取全部电台 - 改进版本
    public void getAllStationsByBatch() {
        int offset = 0;
        int batchSize = 1000;
        int totalInserted = 0;

        while (true) {
            try {
                String url = "http://fi1.api.radio-browser.info/json/stations?offset=" + offset + "&limit=" + batchSize;
                String json = HttpClientUtil.doGet(url, null);

                if (json == null || json.trim().isEmpty()) {
                    log.warn("获取电台数据为空，offset: {}", offset);
                    break;
                }

                List<Station> stations = JSONObject.parseArray(json, Station.class);
                log.info("获取第{}到{}个电台，数量: {}", offset, offset + batchSize, stations.size());

                if (stations == null || stations.isEmpty()) {
                    log.info("没有更多数据，终止获取");
                    break;
                }

                // 插入数据
                List<BatchResult> aaa = stationMapper.insert(stations);
                totalInserted += aaa.size();
                log.info("BatchResult条{}", aaa);
                log.info("成功插入{}条数据，累计插入: {}条", aaa.size(), totalInserted);

                // 更新偏移量
                offset += batchSize;

                // 添加延迟避免请求过于频繁
                Thread.sleep(3000);
            } catch (Exception e) {
                log.error("获取或插入电台数据失败，offset: {}", offset, e);
                // 可以选择继续下一个批次或终止
                offset += batchSize;
            }
        }

        log.info("电台数据同步完成，总共插入: {}条", totalInserted);
    }

    // 最受欢迎的
    public void getTopClick() {
        String url = "http://fi1.api.radio-browser.info/json/stations/topclick?offset=" + 0 + "&limit=" + 100;
        String json = HttpClientUtil.doGet(url, null);
        List<Station> stations = JSONObject.parseArray(json, Station.class);

        log.info("电台数据同步完成，总共插入: {}条", stations.size());
    }

    // 投票最多
    public void getTopVote() {
        String url = "http://fi1.api.radio-browser.info/json/stations/topvote?offset=" + 0 + "&limit=" + 100;
        String json = HttpClientUtil.doGet(url, null);
        List<Station> stations = JSONObject.parseArray(json, Station.class);

        log.info("电台数据同步完成，总共插入: {}条", stations.size());
    }

    // 最近点击次数最多的站点
    public void getLastClick() {
        String url = "http://fi1.api.radio-browser.info/json/stations/lastclick?offset=" + 0 + "&limit=" + 100;
        String json = HttpClientUtil.doGet(url, null);
        List<Station> stations = JSONObject.parseArray(json, Station.class);

        log.info("电台数据同步完成，总共插入: {}条", stations.size());
    }

    // 按最近更改/添加的站点
    public void getLastChange() {
        String url = "http://fi1.api.radio-browser.info/json/stations/lastchange?offset=" + 0 + "&limit=" + 100;
        String json = HttpClientUtil.doGet(url, null);
        List<Station> stations = JSONObject.parseArray(json, Station.class);

        log.info("电台数据同步完成，总共插入: {}条", stations.size());
    }
}
