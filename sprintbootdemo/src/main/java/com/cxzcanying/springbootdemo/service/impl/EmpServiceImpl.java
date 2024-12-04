package com.cxzcanying.springbootdemo.service.impl;

import com.cxzcanying.springbootdemo.mapper.EmpMapper;
import com.cxzcanying.springbootdemo.pojo.Emp;
import com.cxzcanying.springbootdemo.pojo.PageBean;
import com.cxzcanying.springbootdemo.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
//        Long count =empMapper.count();
//        Integer start =(page-1)*pageSize;////计算起始索引 , 公式: (页码-1)*页大小
//        List<Emp> empList=empMapper.list(start,pageSize);
//        return new PageBean(count,empList);

        PageHelper.startPage(page,pageSize);
        List<Emp> empList = empMapper.list(name,gender,begin,end);
        Page<Emp> p= (Page<Emp>) empList;
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
}
