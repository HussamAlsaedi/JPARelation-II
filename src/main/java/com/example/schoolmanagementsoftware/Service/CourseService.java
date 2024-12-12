package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repostiroy.CourseRepository;
import com.example.schoolmanagementsoftware.Repostiroy.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    @Autowired
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void addCourse(Integer teacherId, Course course) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if (teacher == null) {
            throw new IllegalArgumentException("Teacher not found");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public void updateCourse(Integer teacherId, Integer courseId, Course course) {
      Teacher teacher = teacherRepository.findTeacherById(teacherId);
        Course course1 = courseRepository.findCourseByCourse_id(courseId);
        if (course1 == null && teacher == null) {
          throw new IllegalArgumentException("Course not found");
        }
        course1.setCourse_id(courseId);
        course1.setName(course.getName());
        course1.setTeacher(teacher);
        courseRepository.save(course1);

    }

    public void deleteCourse(Integer teacherId, Integer courseId) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        Course course1 = courseRepository.findCourseByCourse_id(courseId);
        if (course1 == null && teacher == null) {
            throw new IllegalArgumentException("Course not found");
        }
        course1.setTeacher(null);
        courseRepository.delete(course1);
    }


    public String getTeacherNameByCourseId(Integer courseId) {
        Course course = courseRepository.findCourseByCourse_id(courseId);
        if (course == null || course.getTeacher() == null) {
            throw new RuntimeException("Course or Teacher not found.");
        }
        return course.getTeacher().getName();
    }

    }
