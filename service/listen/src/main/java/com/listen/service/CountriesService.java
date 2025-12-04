package com.listen.service;

import com.listen.entity.Countries;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.baomidou.mybatisplus.extension.service.IService;
import com.listen.dto.PageQueryDTO;
import com.common.result.PageResult;

/**
* 国家实体类(Countries)表服务接口
*
* @author makejava
* @since 2025-12-04 15:21:37
  */
  public interface CountriesService extends IService<Countries> {

    PageResult<Countries> page(PageQueryDTO pageQueryDTO);
}
