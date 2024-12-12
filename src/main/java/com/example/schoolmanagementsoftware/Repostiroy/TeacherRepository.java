package com.example.schoolmanagementsoftware.Repostiroy;

import com.example.schoolmanagementsoftware.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query("select t from Teacher t where t.id =:teacherId")
    Teacher findTeacherById(@Param("teacherId") int teacherId);


}
