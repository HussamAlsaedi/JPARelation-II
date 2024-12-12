package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.ApiResponse.ApiResponse;
import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Service.CourseService;
import com.example.schoolmanagementsoftware.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;


    @GetMapping("/get")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/add/{teacherId}")
    public ResponseEntity<ApiResponse> addCourse(@PathVariable int teacherId, @RequestBody @Valid Course course) {

        courseService.addCourse(teacherId, course);
       return ResponseEntity.status(200).body(new ApiResponse("successfully added course"));
    }

    @PutMapping("/update/{teacherId}/{courseId}")
    public ResponseEntity<ApiResponse> updateCourse(@PathVariable int teacherId, @PathVariable int courseId, @RequestBody @Valid Course course) {
        courseService.updateCourse(teacherId, courseId, course);
        return ResponseEntity.status(200).body(new ApiResponse("successfully updated course"));
    }

    @DeleteMapping("/delete/{teacherId}/{courseId}")
    public ResponseEntity<ApiResponse> deleteCourse(@PathVariable int teacherId, @PathVariable int courseId) {
        courseService.deleteCourse(teacherId, courseId);
        return ResponseEntity.status(200).body(new ApiResponse("successfully deleted course"));
    }

    @GetMapping("/getTeacherNameByCourseId/{courseId}")
    public String getTeacherName(@PathVariable Integer courseId) {
        return courseService.getTeacherNameByCourseId(courseId);
    }
}
