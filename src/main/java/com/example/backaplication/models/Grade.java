package com.example.backaplication.models;

import java.math.BigDecimal;

public class Grade {
    private Integer gradeId;
    private BigDecimal grade;

    public Grade() {}

    public Grade(Integer gradeId, BigDecimal grade) {
        this.gradeId = gradeId;
        this.grade = grade;
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


}
