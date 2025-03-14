package com.example.backaplication.models;

import java.util.Date;

public class Student {
    private Integer idStudent;
    private Integer grade;
    private Date birthdate;
    private String address;

    public Student() {}

    public Student(Integer idStudent, Integer grade, Date birthdate, String address) {
        this.idStudent = idStudent;
        this.grade = grade;
        this.birthdate = birthdate;
        this.address = address;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
