package com.example.schoolmanagementsoftware.Repostiroy;

import com.example.schoolmanagementsoftware.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("select  c from Course c where c.course_id=:course_id")
    Course findCourseByCourse_id(@Param("course_id") Integer course_id);


}
