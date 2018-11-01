package com.fif.springboot;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fif.springboot.mapper.StudentMapper;
import com.fif.springboot.pojo.ResponseInfo;
import com.fif.springboot.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/spring")
public class SpringBootController {

    @Autowired
    StudentMapper studentMapper;

    @RequestMapping("/getAllStudents")
    public ResponseInfo getAllStudents() {
        try {
            List<Student> studentAll = studentMapper.getStudentAll();
            return new ResponseInfo(200, null, studentAll);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseInfo(201, null, null);
        }
    }
    @RequestMapping("/insertStudent")
    public ResponseInfo insertStudent(@RequestParam("studentName") String studentName, @RequestParam("studentSex") String studentSex,
                                      @RequestParam("stuBirthday") String stuBirthday
                                      ) {
        try {
            Student student = new Student();
            UUID uuid = UUID.randomUUID();
            student.setStudentID(uuid.toString());
            student.setStudentName(studentName);
            student.setStudentSex(studentSex);
            student.setStuBirthday(stuBirthday);
            studentMapper.insertStudent(student);
            return new ResponseInfo(200, "插入数据成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseInfo(201, "插入数据失败", null);
        }
    }

    @RequestMapping("/deleteStudent")
    public ResponseInfo deleteStudent(@RequestParam("studentID") String studentID) {
        try {
            studentMapper.deleteStudent(studentID);
            return new ResponseInfo(201, "删除成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseInfo(201, "删除失败", null);
        }
    }

    @RequestMapping("/getStudentWithName")
    public ResponseInfo getStudentWithName(@RequestParam("studentName") String studentName) {
        try {
            List<Student> students = studentMapper.getStudent(studentName);
            if (students == null || students.size() == 0) {
                return new ResponseInfo(201, "未查询到相关信息", students);
            } else {
                return new ResponseInfo(200, "", students);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseInfo(200, "", null);
        }
    }

    @RequestMapping("/updateStudent")
    public ResponseInfo updateStudent(@RequestParam("studentID") String studentID, @RequestParam("studentName") String studentName,
                                      @RequestParam("studentSex") String studentSex,
                              @RequestParam("stuBirthday") String stuBirthday) {
        try {
            Student student = new Student();
            student.setStudentID(studentID);
            student.setStudentName(studentName);
            student.setStudentSex(studentSex);
            student.setStuBirthday(stuBirthday);
            studentMapper.updateStudent(student);
            return new ResponseInfo(200, "修改信息成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseInfo(201, "修改信息失败", null);
        }
    }
}
