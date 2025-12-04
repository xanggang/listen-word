package com.listen.service.impl;

import com.listen.entity.User;
import com.listen.mapper.UserMapper;
import com.listen.service.UserService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.common.result.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.listen.dto.PageQueryDTO;

/**
 * 标签实体类(User)表服务实现类
 *
 * @author makejava
 * @since 2025-12-03 12:22:40
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapperMapper;

    public PageResult<User> page(PageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());

        Page<User> page = userMapperMapper.page(pageQueryDTO);

        return new PageResult(page.getTotal(), page.getResult());
    }
}

