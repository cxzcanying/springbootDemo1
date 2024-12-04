package com.cxzcanying.springbootdemo.service.impl;

import com.cxzcanying.springbootdemo.mapper.DeptMapper;
import com.cxzcanying.springbootdemo.pojo.Dept;
import com.cxzcanying.springbootdemo.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private  DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addByName(dept);
    }


}
