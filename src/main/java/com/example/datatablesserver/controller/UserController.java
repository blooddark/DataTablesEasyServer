package com.example.datatablesserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.datatablesserver.dto.CommonResponseDTO;
import com.example.datatablesserver.dto.datatables.DataTablesResponseDTO;
import com.example.datatablesserver.entity.User;
import com.example.datatablesserver.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 * @author Eddy
 */
@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获取信息列表
     * @param start 开始条数
     * @param length 每页条数
     * @param draw 请求认证
     * @param requestMap 列条件和排序条件
     * @return DataTables 要求的表格数据
     */
    @GetMapping
    public DataTablesResponseDTO getUserList(Long start, Long length, String draw,
                                             @RequestParam Map<String, String> requestMap) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 条件查询
        for (int i = 0; requestMap.containsKey("columns["+i+"][data]"); i++) {
            queryWrapper.like(requestMap.get("columns["+i+"][data]"), requestMap.get("columns["+i+"][search][value]"));
        }
        // 排序
        for (int i = 0; requestMap.containsKey("order["+i+"][column]"); i++) {
            queryWrapper.orderBy(true, "asc".equals(requestMap.get("order["+i+"][dir]")),
                    requestMap.get("columns["+requestMap.get("order["+i+"][column]")+"][data]"));
        }
        IPage<User> page = new Page<>(start / length + 1, length);
        return DataTablesResponseDTO.builder()
                .data(userService.page(page, queryWrapper).getRecords())
                .draw(draw)
                .recordsTotal(userService.count())
                .recordsFiltered(userService.count(queryWrapper))
                .build();
    }
    @PostMapping
    public CommonResponseDTO addUser(User user) {
        user.setId(null);
        userService.save(user);
        return CommonResponseDTO.builder()
                .code(0)
                .msg("success")
                .build();
    }
    @PutMapping
    public CommonResponseDTO altUser(User user) {
        if (user.getId() == null) {
            return CommonResponseDTO.builder()
                    .code(1)
                    .msg("没有ID")
                    .build();
        }
        if (userService.getById(user.getId()) == null) {
            return CommonResponseDTO.builder()
                    .code(2)
                    .msg("未知ID")
                    .build();
        }
        userService.updateById(user);
        return CommonResponseDTO.builder()
                .code(0)
                .msg("success")
                .build();
    }
    @DeleteMapping
    public CommonResponseDTO delUser(@RequestParam("id[]") Long[] id) {
        userService.removeByIds(Arrays.asList(id));
        return CommonResponseDTO.builder()
                .code(0)
                .msg("success")
                .build();
    }
}
