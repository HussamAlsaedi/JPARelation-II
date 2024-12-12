package com.example.schoolmanagementsoftware.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class AddressDTO {

    @NotNull(message = "teacher_id is mandatory.")
    private Integer teacher_id;

    @NotEmpty(message = "street is mandatory.")
    @Column( nullable = false)
    private String street;

    @NotEmpty(message = "area is mandatory.")
    @Column( nullable = false)
    private String area;

    @NotNull(message = "buildingNumber is mandatory.")
    @Column( nullable = false)
    private Integer buildingNumber;
}
