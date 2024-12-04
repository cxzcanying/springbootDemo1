package com.cxzcanying.mybatisdemo1;

import com.cxzcanying.mybatisdemo1.mapper.EmpMapper;
import com.cxzcanying.mybatisdemo1.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class MybatisDemo1ApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDelete(){
//        int delete = empMapper.delete(16);
//        System.out.println(delete);
        empMapper.delete(16);
    }

    @Test
    public void testInsert(){
        Emp emp=new Emp();
        emp.setUsername("Tom");
        emp.setName("汤姆");
        emp.setImage("1.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 2);
        emp.setEntrydate(LocalDate.of(2005,10,20));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.insert(emp);
    }
}
