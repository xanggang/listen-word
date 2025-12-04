package com.listen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.listen.dto.PageQueryDTO;
import com.listen.entity.Languages;
import com.listen.entity.Tags;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagsMapper extends BaseMapper<Tags> {

    // 分页查询
    Page<Tags> page(PageQueryDTO pageQueryDTO);

    @Select("select * from tags order by stationcount desc")
    List<Tags> list();
}
