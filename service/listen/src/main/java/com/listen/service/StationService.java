package com.listen.service;

import com.listen.dto.FuzzyStationQuery;
import com.listen.dto.StationQuery;
import com.listen.entity.Station;
import com.baomidou.mybatisplus.extension.service.IService;
import com.listen.dto.PageQueryDTO;
import com.common.result.PageResult;

import java.util.List;

/**
* 电台实体类(Station)表服务接口
*
* @author makejava
* @since 2025-12-04 15:49:57
  */
  public interface StationService extends IService<Station> {

    PageResult<Station> page(StationQuery stationQuery);

    PageResult<Station> search(FuzzyStationQuery fuzzyStationQuery);
}
