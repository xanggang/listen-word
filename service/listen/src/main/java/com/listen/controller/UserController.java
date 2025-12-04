package com.listen.controller;



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
import com.listen.entity.User;
import com.listen.service.UserService;

/**
 * 标签实体类(User)表控制层
 *
 * @author makejava
 * @since 2025-12-03 12:03:52
 */
@RestController
@RequestMapping("user")
public class UserController  {

    @Autowired
    private UserService userService;

    /**
     * 新增分类
     */
    @PostMapping("/create")
    public Result<Boolean> save(@RequestBody User user) {
        return Result.success(this.userService.save(user));
    }

    /**
     * 分页查询
     */
    @PostMapping("/page")
    public Result<PageResult<User>> getPageList(@RequestBody PageQueryDTO pageQueryDTO) {
        PageResult<User> pageResult = this.userService.page(pageQueryDTO);

        return Result.success(pageResult);
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody User user) {
        return Result.success(this.userService.removeById(user.getId()));
    }

    /**
     * 编辑分类
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody User user) {
        return Result.success(this.userService.updateById(user));
    }

    /**
     * 查询单个详情
     */
    @PostMapping("/detail")
    public Result<User> getDetailById(@RequestBody User user) {
        return Result.success(this.userService.getById(user.getId()));
    }
}
