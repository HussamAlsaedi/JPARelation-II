package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.Model.Address;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repostiroy.AddressRepository;
import com.example.schoolmanagementsoftware.Repostiroy.TeacherRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher findTeacherById(Integer teacherId) {

        return teacherRepository.findTeacherById(teacherId);
    }

    public void  addTeacher(@RequestBody @Valid Teacher teacher) {
        teacherRepository.save(teacher);

    }

    public void updateTeacher(Integer id, Teacher teacher) {
     Teacher teach = teacherRepository.findTeacherById(id);
        if (teach == null) {
            throw new RuntimeException("Customer not found");
        }
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer id) {

        Teacher teach = teacherRepository.findTeacherById(id);
        if (teach == null) {
            throw new RuntimeException("Teacher not found");
        }

        Address address = addressRepository.findAddressById(id);
        if (address == null) {
            throw new RuntimeException("Address not found");
        }
        teach.setAddress(null);
        addressRepository.delete(address);
        teacherRepository.delete(teach);

    }
}
