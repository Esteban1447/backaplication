package com.example.backaplication.models;

import com.example.backaplication.helper.Usertype;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer userId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private Usertype userType;

    @OneToMany(mappedBy = "user")
    private List<Student> students;

    @OneToMany(mappedBy = "user")
    private List<Teacher> teachers;

    public User() {}

    public User(Integer userId, String name, String email, String password, String phone, Usertype userType) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userType = userType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Usertype getUserType() {
        return userType;
    }

    public void setUserType(Usertype userType) {
        this.userType = userType;
    }
}
