package com.example.Course_Register_React_SpringBoot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CourseRegisteredModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;
    private String userPwd;
    private String userGender;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public CourseRegisteredModel(String userName, String userPwd, String userGender) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userGender = userGender;
    }

    public CourseRegisteredModel() {
    }
}
