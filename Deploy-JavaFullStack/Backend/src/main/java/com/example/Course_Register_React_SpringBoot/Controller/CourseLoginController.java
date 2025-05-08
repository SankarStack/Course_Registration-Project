package com.example.Course_Register_React_SpringBoot.Controller;

import com.example.Course_Register_React_SpringBoot.Model.CourseLoginModel;
import com.example.Course_Register_React_SpringBoot.Service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class CourseLoginController {

    @Autowired
    CourseRegistrationService courseRegistrationService;

    @PostMapping("/login")
    public boolean loginRegisteredUser(@RequestBody CourseLoginModel user){
        return courseRegistrationService.loginRegisteredUser(user);
    }
}
