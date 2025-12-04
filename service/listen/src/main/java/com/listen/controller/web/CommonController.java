package com.listen.controller.web;

import com.common.result.PageResult;
import com.common.result.Result;
import com.listen.dto.PageQueryDTO;
import com.listen.dto.StationQuery;
import com.listen.entity.Countries;
import com.listen.entity.Languages;
import com.listen.entity.Station;
import com.listen.entity.Tags;
import com.listen.mapper.CountriesMapper;
import com.listen.mapper.LanguagesMapper;
import com.listen.service.CountriesService;
import com.listen.service.LanguagesService;
import com.listen.service.StationService;
import com.listen.service.TagsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/common")
@Slf4j
public class CommonController {

    @Autowired
    LanguagesService languagesService;

    @Autowired
    LanguagesMapper languagesMapper;

    @Autowired
    CountriesService countriesService;

    @Autowired
    CountriesMapper countriesMapper;

    @Autowired
    TagsService tagsService;

    @Autowired
    StationService stationService;

    /**
     * Query all languages
     * @return List of languages
     */
    @PostMapping("/languages")
    public Result<List<Languages>> getLanguages() {
        log.info("Query all languages");
        List list =  languagesMapper.list();
        log.info("Query all languages={}", list);
        return Result.success(list);
    }

    /**
     * Query all countries
     * @return List of countries
     */
    @PostMapping("/countries")
    public Result<List<Countries>> getCountries() {
        return Result.success(countriesMapper.list());
    }

    /**
     * Query all tags
     * @return List of tags
     */
    @PostMapping("/tags")
    public  Result<List<Tags>> getTags() {
        return Result.success(tagsService.list());
    }

    @PostMapping("/tags/page")
    public  Result<PageResult<Tags>> getTagsPage(@RequestBody PageQueryDTO pageQueryDTO) {
        PageResult<Tags> pageResult = tagsService.page(pageQueryDTO);
        return Result.success(pageResult);
    }

    @PostMapping("/station/page")
    public Result<PageResult<Station>> getStation(@RequestBody StationQuery stationQuery) {
        PageResult<Station> pageResult = stationService.page(stationQuery);
        return Result.success(pageResult);
    }

    @PostMapping("/station")
    public Result<Station> getStationByID(@RequestBody Station station) {
        Station res = stationService.getById(station.getId());
        return Result.success(res);
    }
}
