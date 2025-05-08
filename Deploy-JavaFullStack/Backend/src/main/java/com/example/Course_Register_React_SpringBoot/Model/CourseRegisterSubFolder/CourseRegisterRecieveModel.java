package com.example.Course_Register_React_SpringBoot.Model.CourseRegisterSubFolder;

public class CourseRegisterRecieveModel {
    private String userName;
    private String courseName;
    private String courseDuration;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public CourseRegisterRecieveModel(String userName, String courseName, String courseDuration) {
        this.userName = userName;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
    }
}
