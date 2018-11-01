package com.fif.springboot.mapper;

import com.fif.springboot.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    public List<Student> getStudent(String studentName);
    public Student getStudentAndClass(String studentID);
    public List<Student> getStudentAll();
    public void insertStudent(Student student);
    public void deleteStudent(String studentID);
    public void updateStudent(Student student);
}
