package com.listen.service;

import com.listen.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.baomidou.mybatisplus.extension.service.IService;
import com.listen.dto.PageQueryDTO;
import com.common.result.PageResult;

/**
* 标签实体类(User)表服务接口
*
* @author makejava
* @since 2025-12-03 12:09:53
  */
  public interface UserService extends IService<User> {

    PageResult<User> page(PageQueryDTO pageQueryDTO);
}
