package com.example.backaplication.models;

import com.example.backaplication.helper.AttendanceStatus;

import java.util.Date;

public class Attendance {
    private Integer idAttendance;
    private Date date;
    private AttendanceStatus status;

    public Attendance() {}

    public Attendance(Integer idAttendance, Integer idStudent, Integer idCourse, Date date, AttendanceStatus status) {
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

    public AttendanceStatus getStatus() {
        return status;
    }

    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }
}
