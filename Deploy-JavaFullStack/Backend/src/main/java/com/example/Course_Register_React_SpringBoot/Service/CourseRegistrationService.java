package com.example.Course_Register_React_SpringBoot.Service;

import com.example.Course_Register_React_SpringBoot.Model.*;
import com.example.Course_Register_React_SpringBoot.Model.CourseRegisterSubFolder.CourseRegisterRecieveModel;
import com.example.Course_Register_React_SpringBoot.Repository.AvailableCourseRepo;
import com.example.Course_Register_React_SpringBoot.Repository.CourseRegisterFormRepo;
import com.example.Course_Register_React_SpringBoot.Repository.CourseRegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseRegistrationService implements UserDetailsService {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    CourseRegisterRepo courseRegisterRepo;

    @Autowired
    AvailableCourseRepo availableCourseRepo;
    public List<AvailableCoursesModel> getAvailableCourses(){
        return availableCourseRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        CourseRegisteredModel user = courseRegisterRepo.findByUserName(userName);
        if(user == null)
            throw new UsernameNotFoundException("User Not Found --");
        return new UserPrincipalRegistration(user);
    }

    public void addRegisteredUser(CourseRegisteredModel user) {
        user.setUserPwd(encoder.encode(user.getUserPwd()));
        courseRegisterRepo.save(user);
    }

    public boolean loginRegisteredUser(CourseLoginModel user) {
        List<CourseRegisteredModel> model =  courseRegisterRepo.findByUserNameList(user.getUserName());
        if(model.isEmpty()) return false;
        for(CourseRegisteredModel mm:model){
            if(encoder.matches(user.getUserPwd(), mm.getUserPwd()))
                return true;
        }
        return false;
    }

    @Autowired
    CourseRegisterFormRepo courseRegisterFormRepo;


    int id = 1005;
    public int addCourseRegisteredUser(CourseRegisterRecieveModel user){
        courseRegisterFormRepo.addCourseRegisteredUser(++id,user.getUserName(),user.getCourseName(),user.getCourseDuration());
        return id;
    }

    public void updateCourseDetails(UpdateCourseRegModel model) {
        String id = model.getUserId();
        String numberStr = id.replaceAll("\\D+", ""); // Remove non-digit characters
        int id_num = Integer.parseInt(numberStr);
        courseRegisterFormRepo.updateCourseDetails(id_num, model.getUserName(), model.getCourseName(), model.getCourseDuration());
    }
}
