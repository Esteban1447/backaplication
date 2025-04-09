package com.example.backaplication.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subject")
    private Integer subjectId;

    @Column(name = "subject_name")
    private String subjectName;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    @OneToMany(mappedBy = "subject")
    private List<Grade> grades;

    public Subject() {}

    public Subject(Integer subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
