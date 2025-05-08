package com.example.Course_Register_React_SpringBoot.Controller;

import com.example.Course_Register_React_SpringBoot.Model.CourseRegisteredModel;
import com.example.Course_Register_React_SpringBoot.Service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class PostRegisteredUser {

    @Autowired
    CourseRegistrationService courseRegistrationService;

    @PostMapping("/addUser")
    public String addRegisteredUser(@RequestBody CourseRegisteredModel user){
        courseRegistrationService.addRegisteredUser(user);
        return "Successfully Added --";
    }
}
