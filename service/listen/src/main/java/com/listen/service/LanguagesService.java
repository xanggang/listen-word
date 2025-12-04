package com.listen.service;

import com.listen.entity.Languages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.baomidou.mybatisplus.extension.service.IService;
import com.listen.dto.PageQueryDTO;
import com.common.result.PageResult;

/**
* 语言实体类(Languages)表服务接口
*
* @author makejava
* @since 2025-12-04 15:21:28
  */
  public interface LanguagesService extends IService<Languages> {

    PageResult<Languages> page(PageQueryDTO pageQueryDTO);

}
