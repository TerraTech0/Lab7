package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Courses {

    @NotEmpty(message = "course id can't be empty!")
    private String courseId;

    @NotNull(message = "course hours can't be null!")
    @Max(value = 4, message = "course hours can't be more than 4")
    private int courseHours;


    private boolean pass;

    private boolean courseRequierments;

}
