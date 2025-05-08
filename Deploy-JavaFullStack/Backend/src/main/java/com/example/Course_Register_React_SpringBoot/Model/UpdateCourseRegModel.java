package com.example.Course_Register_React_SpringBoot.Model;


public class UpdateCourseRegModel {
    private String userId;
    private String userName;
    private String courseName;
    private String courseDuration;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public UpdateCourseRegModel(String userId, String userName, String courseName, String courseDuration) {
        this.userId = userId;
        this.userName = userName;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
    }
}
