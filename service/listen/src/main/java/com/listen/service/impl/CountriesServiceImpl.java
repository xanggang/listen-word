package com.listen.service.impl;

import com.listen.entity.Countries;
import com.listen.mapper.CountriesMapper;
import com.listen.service.CountriesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.common.result.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.listen.dto.PageQueryDTO;

/**
* 国家实体类(Countries)表服务实现类
*
* @author makejava
  * @since 2025-12-04 15:21:37
    */
    @Service
    public class CountriesServiceImpl extends ServiceImpl<CountriesMapper, Countries> implements CountriesService {

    @Autowired
    private CountriesMapper countriesMapperMapper;

      public PageResult<Countries> page(PageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());

          Page<Countries> page = countriesMapperMapper.page(pageQueryDTO);

          return new PageResult(page.getTotal(), page.getResult());
      }
  }

