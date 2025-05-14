package com.example.backaplication.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tuition")
public class Tuition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tuition")
    private Integer tuitionId;

    @Column(name = "tuition_date")
    private Date tuitionDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    public Tuition() {}

    public Tuition(Integer tuitionId, Date tuitionDate) {
        this.tuitionId = tuitionId;
        this.tuitionDate = tuitionDate;
    }

    public Integer getTuitionId() {
        return tuitionId;
    }

    public void setTuitionId(Integer tuitionId) {
        this.tuitionId = tuitionId;
    }

    public Date getTuitionDate() {
        return tuitionDate;
    }

    public void setTuitionDate(Date tuitionDate) {
        this.tuitionDate = tuitionDate;
    }


}
