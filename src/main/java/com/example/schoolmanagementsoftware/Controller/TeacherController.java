package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.ApiResponse.ApiResponse;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    @Autowired
    private final TeacherService teacherService;

    @GetMapping("/get")
    public List<Teacher> getAllTeacher() {
        return teacherService.findAllTeachers();
    }
    @GetMapping("/getTeacherById/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Integer teacherId) {
        Teacher teacher = teacherService.findTeacherById(teacherId);
        return ResponseEntity.ok(teacher);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addTeacher(@RequestBody @Valid Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully added teacher"));
    }

    @PutMapping("/update/{teacherId}")
    public ResponseEntity<ApiResponse> updateTeacher(@PathVariable Integer teacherId, @RequestBody @Valid Teacher teacher) {
        teacherService.updateTeacher(teacherId, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully updated teacher"));
    }

    @DeleteMapping("delete/{teacherId}")
    public ResponseEntity<ApiResponse> deleteTeacher(@PathVariable Integer teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully deleted teacher"));
    }
}