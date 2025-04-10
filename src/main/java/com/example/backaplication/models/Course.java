package com.example.backaplication.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Integer courseId;

    @Column(name = "course_name")
    private String courseName;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @JsonManagedReference
    @OneToMany(mappedBy = "course")
    private List<Tuition> tuitions;

    @JsonManagedReference
    @OneToMany(mappedBy = "course")
    private List<Subject> subjects;

    @JsonManagedReference
    @OneToMany(mappedBy = "course")
    private List<Attendance> attendances;
    public Course() {
    }

    public Course(Integer courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
