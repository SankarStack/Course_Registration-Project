package com.example.Course_Register_React_SpringBoot.Repository;

import com.example.Course_Register_React_SpringBoot.Model.CourseRegisteredModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRegisterRepo extends JpaRepository<CourseRegisteredModel,Integer> {
    CourseRegisteredModel findByUserName(String userName);

    @Query(nativeQuery = true,value = "select * from course_registered_model where user_name = :user_name")
    List<CourseRegisteredModel> findByUserNameList(@Param("user_name")  String userName);

//    @Query(nativeQuery = true,value = "select * from course_registered_model where user_pwd = :user_pwd")
//    CourseRegisteredModel findByUserPwd(@Param("user_pwd") String userPwd);
}
