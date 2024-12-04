package com.cxzcanying.springbootdemo.controller;


import com.cxzcanying.springbootdemo.pojo.Dept;
import com.cxzcanying.springbootdemo.pojo.Result;
import com.cxzcanying.springbootdemo.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

//    private static Logger log= LoggerFactory.getLogger(DeptController.class);
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        List<Dept> deptList=deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门");
        deptService.delete(id);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增:{}",dept);
        deptService.addDept(dept);
        return Result.success();

    }
}
