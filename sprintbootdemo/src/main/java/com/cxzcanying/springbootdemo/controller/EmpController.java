package com.cxzcanying.springbootdemo.controller;


import com.cxzcanying.springbootdemo.pojo.Emp;
import com.cxzcanying.springbootdemo.pojo.PageBean;
import com.cxzcanying.springbootdemo.pojo.Result;
import com.cxzcanying.springbootdemo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end) {
        log.info("分页查询，参数：{},{},{},{},{},{}", page, pageSize,name,gender,begin,end);
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin,end);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        empService.delete(ids);
        return Result.success();
    }


    //新增
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工,emp:{}",emp);
        empService.save(emp);
        return Result.success();
    }
    //查询回显
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("查询回显,empId:{}",id);
        Emp emp =empService.getById(id);
        return Result.success(emp);
    }

    //修改员工
    @PutMapping
    public Result update(Emp emp){
        log.info("修改员工,emp:{}",emp);
        empService.update(emp);
        return Result.success();
    }
}
