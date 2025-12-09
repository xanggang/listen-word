package com.listen.service.impl;

import com.listen.dto.FuzzyStationQuery;
import com.listen.dto.StationQuery;
import com.listen.entity.Station;
import com.listen.mapper.StationMapper;
import com.listen.service.StationService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.common.result.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.listen.dto.PageQueryDTO;

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

    public PageResult<Station> page(StationQuery stationQuery) {
        PageHelper.startPage(stationQuery.getPage(), stationQuery.getPageSize());

        Page<Station> page = stationMapperMapper.page(stationQuery);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult<Station> search(FuzzyStationQuery fuzzyStationQuery) {
        PageHelper.startPage(fuzzyStationQuery.getPage(), fuzzyStationQuery.getPageSize());

        Page<Station> page = stationMapperMapper.search(fuzzyStationQuery);

        return new PageResult(page.getTotal(), page.getResult());
    }

}

