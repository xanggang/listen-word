package com.listen.service;

import com.listen.entity.Tags;
import com.baomidou.mybatisplus.extension.service.IService;
import com.listen.dto.PageQueryDTO;
import com.common.result.PageResult;

/**
* 语言实体类(Tags)表服务接口
*
* @author makejava
* @since 2025-12-04 15:00:41
  */
  public interface TagsService extends IService<Tags> {

    PageResult<Tags> page(PageQueryDTO pageQueryDTO);
}
