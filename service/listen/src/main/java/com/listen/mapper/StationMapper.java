package com.listen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.listen.dto.FuzzyStationQueryDTO;
import com.listen.dto.StationLocationQueryDTO;
import com.listen.dto.StationQueryDTO;
import com.listen.entity.Station;
import com.listen.vo.StationLocationVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StationMapper extends BaseMapper<Station> {

    // 分页查询
    Page<Station> page(StationQueryDTO stationQueryDTO);

    Page<Station> search(FuzzyStationQueryDTO fuzzyStationQueryDTO);

    List<StationLocationVO> searchByMap(StationLocationQueryDTO stationLocationQueryDTO);
}
