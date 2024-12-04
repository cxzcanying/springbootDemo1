package com.cxzcanying.springbootdemo.service;

import com.cxzcanying.springbootdemo.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     *  查询全部部门数据
     * @return
     */
    List<Dept> list();

    /**
     * 根据id删除部门
     * @param id
     */
    void delete(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    void addDept(Dept dept);
}
