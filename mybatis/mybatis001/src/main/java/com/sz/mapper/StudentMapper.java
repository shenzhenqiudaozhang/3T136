package com.sz.mapper;

import com.sz.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    List<Student> listAll();


    void insert(Student s);

    Student selectByName(String name);

    Student selectByNameAndAge(@Param("name") String name, @Param("age") Integer age);


    int update(Student s);


    int deleteByPrimaryKey(Integer id);
}
