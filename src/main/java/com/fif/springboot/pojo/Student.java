package com.fif.springboot.pojo;

import java.io.Serializable;

public class Student implements Serializable {
    private Class classPo;
    private String stuBirthday;
    private String studentID;
    private String studentName;
    private String studentSex;

    public Class getClassPo() {
        return classPo;
    }

    public void setClassPo(Class classPo) {
        this.classPo = classPo;
    }

    public String getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(String stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }
}
