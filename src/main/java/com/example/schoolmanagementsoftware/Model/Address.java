package com.example.schoolmanagementsoftware.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address    {
    @Id
    private Integer id;

    @NotEmpty(message = "street is mandatory.")
    @Column( nullable = false)
    private String street;

    @NotEmpty(message = "area is mandatory.")
    @Column( nullable = false)
    private String area;

    @NotNull(message = "street is mandatory.")
    @Column( nullable = false)
    private Integer buildingNumber;

    @OneToOne()
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
