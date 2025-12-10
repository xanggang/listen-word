package com.listen.service;

import com.listen.dto.FuzzyStationQueryDTO;
import com.listen.dto.StationLocationQueryDTO;
import com.listen.dto.StationQueryDTO;
import com.listen.entity.Station;
import com.baomidou.mybatisplus.extension.service.IService;
import com.common.result.PageResult;
import com.listen.vo.StationLocationVO;

import java.util.List;

/**
* 电台实体类(Station)表服务接口
*
* @author makejava
* @since 2025-12-04 15:49:57
  */
  public interface StationService extends IService<Station> {

    PageResult<Station> page(StationQueryDTO stationQueryDTO);

    PageResult<Station> search(FuzzyStationQueryDTO fuzzyStationQueryDTO);

    List<StationLocationVO> searchByMap(StationLocationQueryDTO stationLocationQueryDTO);
}
