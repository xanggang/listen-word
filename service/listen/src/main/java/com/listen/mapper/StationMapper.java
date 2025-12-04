package com.listen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.listen.dto.PageQueryDTO;
import com.listen.dto.StationQuery;
import com.listen.entity.Languages;
import com.listen.entity.Station;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StationMapper extends BaseMapper<Station> {

    // 分页查询
    Page<Station> page(StationQuery stationQuery);
}
