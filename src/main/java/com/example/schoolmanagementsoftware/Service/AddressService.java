package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.DTO.AddressDTO;
import com.example.schoolmanagementsoftware.Model.Address;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repostiroy.AddressRepository;
import com.example.schoolmanagementsoftware.Repostiroy.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
     private final AddressRepository addressRepository;
     private final TeacherRepository teacherRepository;


      public List<Address> getAllAdders(){
          return addressRepository.findAll();
      }

      public void  addAdder(AddressDTO addressDTO){
          Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
          if(teacher == null){
              System.out.println("Teacher not found");
          }
          Address address = new Address(null,addressDTO.getStreet(),addressDTO.getArea()
          ,addressDTO.getBuildingNumber(),teacher);
          addressRepository.save(address);

      }

     public void updateAddress(AddressDTO addressDTO) {
         Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
         if (address == null) {
             throw new RuntimeException("address not found")    ;
         }

          address.setStreet(addressDTO.getStreet());
          address.setArea(addressDTO.getArea());
          address.setStreet(addressDTO.getStreet());
           address.setId(addressDTO.getTeacher_id());

         addressRepository.save(address);
     }


}
