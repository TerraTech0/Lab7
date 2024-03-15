package com.example.lab7.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull(message = "Teacher ID can't be null!")
    private int teacherId;

    @NotEmpty(message = "Teacher name can't be empty!")
    @Size(max = 50, message = "Teacher name must be less than 50 characters!")
    private String teacherName;

    @NotEmpty(message = "Subject can't be empty!")
    @Size(max = 50, message = "Subject must be less than 50 characters!")
    private String subject;

    @NotEmpty(message = "Students list can't be null!")
    private List<Student> students;
}
