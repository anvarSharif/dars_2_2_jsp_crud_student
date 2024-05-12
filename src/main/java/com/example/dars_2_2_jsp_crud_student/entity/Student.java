package com.example.dars_2_2_jsp_crud_student.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private UUID id;
    private String firstName;
    private String lastName;
    private Integer age;

}
