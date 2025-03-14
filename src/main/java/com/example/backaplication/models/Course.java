package com.example.backaplication.models;

public class Course {
    private Integer idCourse;
    private String courseName;

    public Course() {}

    public Course(Integer idCourse, String courseName) {
        this.idCourse = idCourse;
        this.courseName = courseName;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
