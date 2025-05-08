package com.example.Course_Register_React_SpringBoot.Repository;

import com.example.Course_Register_React_SpringBoot.Model.AvailableCoursesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableCourseRepo extends JpaRepository<AvailableCoursesModel,Integer> {
}
