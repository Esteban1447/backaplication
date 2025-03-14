package com.example.backaplication.models;

import java.util.Date;

public class Attendance {
    private Integer idAttendance;
    private Date date;
    private String status;

    public Attendance() {}

    public Attendance(Integer idAttendance, Integer idStudent, Integer idCourse, Date date, String status) {
        this.idAttendance = idAttendance;
        this.date = date;
        this.status = status;
    }

    public Integer getIdAttendance() {
        return idAttendance;
    }

    public void setIdAttendance(Integer idAttendance) {
        this.idAttendance = idAttendance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
