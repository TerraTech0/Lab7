package com.example.lab7.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    @NotNull(message = "student id can't be null!")
    private int studentId;

    @NotEmpty(message = "course id can't be empty!")
    private String courseId;

    @NotEmpty(message = "student name can't be empty!")
    private String studentName;

    @NotNull(message = "the student age can't be null!")
    @Min(value = 18, message = "student age must be more than 18!")
    private int studentAge;

    @NotNull(message = "GPA can't be null!")
    private double GPA;

    @NotNull(message = "hourse earnd can't be null!")
    private int hoursEarnd;

    @NotNull(message = "left hours can't be null!")
    @Max(value = 250, message = "left hours can't be more than 250 hours in this major")
    private int hoursLeft;
}
