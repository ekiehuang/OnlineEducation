package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-02-07
 */
@Api(description = "Managing Teachers")
@RestController
@RequestMapping("/eduservice/eduteacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation(value = "The list of all teachers")
    @GetMapping
    public R getAllTeacher() {
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("list", list);
    }

    @ApiOperation(value = "Delete specific teacher")
    @DeleteMapping("{id}")
    public R delTeacher(@PathVariable String id) {
        boolean remove = teacherService.removeById(id);
        if (remove) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}

