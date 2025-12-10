package com.listen.service.impl;

import com.listen.dto.FuzzyStationQueryDTO;
import com.listen.dto.StationLocationQueryDTO;
import com.listen.dto.StationQueryDTO;
import com.listen.entity.Station;
import com.listen.mapper.StationMapper;
import com.listen.service.StationService;
import com.listen.vo.StationLocationVO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.common.result.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;

/**
 * 电台实体类(Station)表服务实现类
 *
 * @author makejava
 * @since 2025-12-04 15:49:57
 */
@Service
public class StationServiceImpl extends ServiceImpl<StationMapper, Station> implements StationService {

    @Autowired
    private StationMapper stationMapperMapper;

    public PageResult<Station> page(StationQueryDTO stationQueryDTO) {
        PageHelper.startPage(stationQueryDTO.getPage(), stationQueryDTO.getPageSize());

        Page<Station> page = stationMapperMapper.page(stationQueryDTO);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult<Station> search(FuzzyStationQueryDTO fuzzyStationQueryDTO) {
        PageHelper.startPage(fuzzyStationQueryDTO.getPage(), fuzzyStationQueryDTO.getPageSize());

        Page<Station> page = stationMapperMapper.search(fuzzyStationQueryDTO);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<StationLocationVO> searchByMap(StationLocationQueryDTO stationLocationQueryDTO) {
        return stationMapperMapper.searchByMap(stationLocationQueryDTO);
    }

}

