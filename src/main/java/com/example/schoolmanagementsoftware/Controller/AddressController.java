package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.ApiResponse.ApiResponse;
import com.example.schoolmanagementsoftware.DTO.AddressDTO;
import com.example.schoolmanagementsoftware.Model.Address;
import com.example.schoolmanagementsoftware.Repostiroy.AddressRepository;
import com.example.schoolmanagementsoftware.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    public List<Address> getAllAddress(){
        return addressService.getAllAdders();
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAdder(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully added address"));
    }

    @PutMapping("/update/")
    public ResponseEntity<ApiResponse> updateAddress(@RequestBody @Valid AddressDTO addressDTO){
     addressService.updateAddress(addressDTO);
     return ResponseEntity.status(200).body(new ApiResponse("Successfully updated address"));
    }

}
