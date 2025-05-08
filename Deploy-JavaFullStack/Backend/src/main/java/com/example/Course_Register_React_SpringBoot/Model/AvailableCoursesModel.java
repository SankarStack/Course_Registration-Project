package com.example.Course_Register_React_SpringBoot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AvailableCoursesModel {
    @Id
    private int courseId;
    private String courseName;
    private String mentorName;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public AvailableCoursesModel(int courseId, String courseName, String mentorName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.mentorName = mentorName;
    }

    public AvailableCoursesModel() {
    }
}
