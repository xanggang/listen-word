package com.listen.mapper;

import com.listen.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.listen.dto.PageQueryDTO;
import com.github.pagehelper.Page;

/**
 * 标签实体类(User)表数据库访问层
 *
 * @author makejava
 * @since 2025-12-03 12:26:26
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{

       // 分页查询
    Page<User> page(PageQueryDTO pageQueryDTO);
}
