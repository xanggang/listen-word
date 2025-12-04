package com.listen.controller.web;

import com.common.result.PageResult;
import com.common.result.Result;
import com.listen.dto.PageQueryDTO;
import com.listen.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.listen.service.UserService;

@RestController
@RequestMapping("/admin/category")
@Slf4j
public class userController11 {

    @Autowired
    private UserService usersService;

    /**
     * 新增分类
     */
    @PostMapping("/create")
    public Result<Boolean> save(@RequestBody User user) {
        return Result.success(usersService.save(user));
    }

    /**
     * 分页查询
     */
    @PostMapping("/page")
    public Result<PageResult<User>> getPageList(@RequestBody PageQueryDTO pageQueryDTO) {
        PageResult<User> pageResult = usersService.page(pageQueryDTO);

        return Result.success(pageResult);
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody User user) {
        return Result.success(usersService.removeById(user.getId()));
    }

    /**
     * 编辑分类
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody User user) {
        return Result.success(usersService.updateById(user));
    }

    /**
     * 查询单个详情
     */
    @PostMapping("/detail")
    public Result<User> getDetailById(@RequestBody User user) {
        return Result.success(usersService.getById(user.getId()));
    }
}
