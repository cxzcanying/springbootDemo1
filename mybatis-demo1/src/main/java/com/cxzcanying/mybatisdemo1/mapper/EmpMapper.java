package com.cxzcanying.mybatisdemo1.mapper;

import com.cxzcanying.mybatisdemo1.pojo.Emp;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmpMapper {
    @Delete("delete from emp where id =#{id}")
    //public void delete(Integer id);
    public void delete(Integer id);

    @Insert("INSERT into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)"+
            "values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);


}
