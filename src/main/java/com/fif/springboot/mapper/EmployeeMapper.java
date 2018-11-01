package com.fif.springboot.mapper;

import com.fif.springboot.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

     @Select("SELECT * FROM employees")
     List<Employee> findAll();
}
