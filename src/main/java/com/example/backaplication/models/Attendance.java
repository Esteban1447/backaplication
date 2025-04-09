package com.example.backaplication.models;

import com.example.backaplication.helper.AttendanceStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_attendance")
    private Integer attendanceId;

    @Column(name = "date")
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AttendanceStatus status;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;


    public Attendance() {}

    public Attendance(Integer attendanceId, Date date, AttendanceStatus status) {
        this.attendanceId = attendanceId;
        this.date = date;
        this.status = status;
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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
