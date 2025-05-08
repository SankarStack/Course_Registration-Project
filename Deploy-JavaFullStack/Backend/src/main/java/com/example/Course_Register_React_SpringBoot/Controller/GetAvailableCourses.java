package com.example.Course_Register_React_SpringBoot.Controller;

import com.example.Course_Register_React_SpringBoot.Model.AvailableCoursesModel;
import com.example.Course_Register_React_SpringBoot.Service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class GetAvailableCourses {

    @Autowired
    CourseRegistrationService courseRegistrationService;


    @GetMapping("/getCourses")
    public List<AvailableCoursesModel> getAvailableCourses(){
        return courseRegistrationService.getAvailableCourses();
    }
}
