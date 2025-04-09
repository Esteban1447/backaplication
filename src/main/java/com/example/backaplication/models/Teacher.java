package com.example.backaplication.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teacher")
    private Integer teacherId;

    @Column
    private String specialty;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;


    public Teacher() {}

    public Teacher(Integer teacherId, String specialty) {
        this.teacherId = teacherId;
        this.specialty = specialty;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
