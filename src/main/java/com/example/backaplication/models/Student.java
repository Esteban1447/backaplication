package com.example.backaplication.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Integer studentId;

    @Column
    private Integer grade;

    @Column
    private Date birthdate;

    @Column
    private String address;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "student")
    private List<Tuition> tuitions;

    @OneToMany(mappedBy = "student")
    private List<Grade> grades;

    @OneToMany(mappedBy = "student")
    private List<Attendance> attendances;

    public Student() {}

    public Student(Integer studentId, Integer grade, Date birthdate, String address) {
        this.studentId = studentId;
        this.grade = grade;
        this.birthdate = birthdate;
        this.address = address;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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
