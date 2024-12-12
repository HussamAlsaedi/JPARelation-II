package com.example.schoolmanagementsoftware.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name is mandatory.")
    @Column( nullable = false)
     private String name;

    @NotNull(message = "age is mandatory.")
    @Column( nullable = false)
     private Integer  age;

    @NotEmpty(message = "email is mandatory.")
    @Email(message = "email must be correct.")
    @Column( nullable = false, unique = true , length = 50)
    private String email;

    @NotNull(message = "salary is mandatory.")
    @Column( nullable = false)
     private Double  salary;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,   mappedBy = "teacher")
    private Set<Course> courses;

}
