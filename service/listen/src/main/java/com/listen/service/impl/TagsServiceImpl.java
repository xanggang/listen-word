package com.listen.service.impl;

import com.listen.entity.Tags;
import com.listen.mapper.TagsMapper;
import com.listen.service.TagsService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.common.result.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.listen.dto.PageQueryDTO;

/**
 * 语言实体类(Tags)表服务实现类
 *
 * @author makejava
 * @since 2025-12-04 15:00:41
 */
@Service
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags> implements TagsService {

    @Autowired
    private TagsMapper tagsMapperMapper;

    public PageResult<Tags> page(PageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());

        Page<Tags> page = tagsMapperMapper.page(pageQueryDTO);

        return new PageResult(page.getTotal(), page.getResult());
    }
}

