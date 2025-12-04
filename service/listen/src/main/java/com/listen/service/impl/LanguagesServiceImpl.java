package com.listen.service.impl;

import com.listen.entity.Languages;
import com.listen.mapper.LanguagesMapper;
import com.listen.service.LanguagesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.common.result.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.listen.dto.PageQueryDTO;

/**
 * 语言实体类(Languages)表服务实现类
 *
 * @author makejava
 * @since 2025-12-04 15:21:28
 */
@Service
public class LanguagesServiceImpl extends ServiceImpl<LanguagesMapper, Languages> implements LanguagesService {

    @Autowired
    private LanguagesMapper LanguagesMapper;

    public PageResult<Languages> page(PageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());

        Page<Languages> page = LanguagesMapper.page(pageQueryDTO);

        return new PageResult(page.getTotal(), page.getResult());
    }
}

