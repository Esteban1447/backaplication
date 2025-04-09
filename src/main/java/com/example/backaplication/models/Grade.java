package com.example.backaplication.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grade")
    private Integer gradeId;

    @Column(name = "grade")
    private BigDecimal grade;

    @Column(name = "evaluation_date")
    private Date evaluationDate;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;

    public Grade() {}

    public Grade(Integer gradeId, BigDecimal grade, Date evaluationDate) {
        this.gradeId = gradeId;
        this.grade = grade;
        this.evaluationDate = evaluationDate;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

}
