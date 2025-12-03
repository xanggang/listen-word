package com.listen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.listen.entity.Country;
import com.listen.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CountriesMapper extends BaseMapper<Country> {


}
