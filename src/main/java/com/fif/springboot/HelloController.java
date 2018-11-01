package com.fif.springboot;

import com.fif.springboot.mapper.EmployeeMapper;
import com.fif.springboot.mapper.StudentMapper;
import com.fif.springboot.pojo.ResponseInfo;
import com.fif.springboot.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Controller
public class HelloController {



    @Value("${content}")
    private String content;

    @Autowired
    private StudentProperties studentProperties;


    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return studentProperties.getName() + "___" + studentProperties.getAge();
    }

    @Resource
    EmployeeMapper employeeMapper;

    @Autowired
    StudentMapper studentMapper;

//    @RequestMapping("/listEmployees")
//    public String listEmployee(Model model) {
///*        List<Employee> all = employeeMapper.findAll();
//        model.addAllAttributes(all);
//        return String.valueOf(all.size());*/
//        Student student = studentMapper.getStudent("123456");
//        System.out.println(student.getStudentSex());
//        return student.getStudentName();
//    }

    @RequestMapping("/dealStudent")
    public String initStudentView(ModelMap map) {
        map.put("name", "Spring Boot");
        return "DealStudent";
    }

}
