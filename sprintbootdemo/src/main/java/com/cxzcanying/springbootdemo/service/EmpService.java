package com.cxzcanying.springbootdemo.service;

import com.cxzcanying.springbootdemo.pojo.Emp;
import com.cxzcanying.springbootdemo.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * 条件分页查询
     * @param page
     * @param pageSize
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin,LocalDate end);

    /**
     * 根据id删除员工
     * @param ids
     */
    void delete(List<Integer> ids);


    /**
     *
     * @param emp
     */
    void save(Emp emp);

    /**
     *
     *根据ID查询员工信息
     * @param id
     * @return
     */
    Emp getById(Integer id);

    /**
     * 修改员工
     * @param emp
     */
    void update(Emp emp);
}
