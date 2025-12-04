package com.listen.mapper;

import com.listen.entity.Countries;
import com.listen.entity.Languages;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.listen.dto.PageQueryDTO;
import com.github.pagehelper.Page;

/**
 * 语言实体类(Languages)表数据库访问层
 *
 * @author makejava
 * @since 2025-12-04 15:21:28
 */
@Mapper
public interface LanguagesMapper extends BaseMapper<Languages>{

       // 分页查询
    Page<Languages> page(PageQueryDTO pageQueryDTO);

    @Select("select * from languages order by stationcount desc")
    List<Languages> list();
}
