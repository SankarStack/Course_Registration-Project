package com.example.Course_Register_React_SpringBoot.Repository;

import com.example.Course_Register_React_SpringBoot.Model.CourseRegisterSubFolder.CourseRegisterFormModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegisterFormRepo extends JpaRepository<CourseRegisterFormModel,Integer> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "insert into course_register_form_model(user_id,user_name,course_name,course_duration) values(:user_id,:user_name,:course_name,:course_duration)")
    void addCourseRegisteredUser(@Param("user_id") int userId, @Param("user_name") String userName,@Param("course_name") String courseName, @Param("course_duration") String courseDuration);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update course_register_form_model set user_name = :user_name,course_name = :course_name,course_duration = :course_duration where user_id = :user_id")
    void updateCourseDetails(@Param("user_id") int userId, @Param("user_name") String userName,@Param("course_name") String courseName, @Param("course_duration") String courseDuration);
}
