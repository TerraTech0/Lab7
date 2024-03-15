package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model.Courses;
import com.example.lab7.Service.CoursesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/courses/")
@RequiredArgsConstructor
public class CoursesController {

    private final CoursesService coursesService;

    @GetMapping("/get")
    public ArrayList<Courses> getCourses(){
        return coursesService.getCourses();
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Courses courses, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        coursesService.addCourse(courses);
        return ResponseEntity.status(200).body(new ApiResponse("course added successfully!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable String id, @RequestBody @Valid Courses courses, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        coursesService.updateCourse(id, courses);
        return ResponseEntity.status(200).body(new ApiResponse("course updated successfully!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable String id){
        coursesService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("course deleted successfully!"));
    }

    @GetMapping("/search/{id}")
    public ResponseEntity getCourseById(@PathVariable String id){
        return ResponseEntity.status(200).body(coursesService.getCourseById(id));
    }

    @GetMapping("/courses-exist/{id}")
    public ResponseEntity courseExists(@PathVariable String id){
        if (id != null){
            return ResponseEntity.status(200).body(coursesService.courseExists(id));
        }
        return ResponseEntity.status(400).body(new ApiResponse("id not found!"));

    }

    @GetMapping("/pass-courses")
    public ResponseEntity passCourses(){
        return ResponseEntity.status(200).body(coursesService.passCourses());
    }

    @GetMapping("/failed-courses")
    public ResponseEntity getFailedCourses(){
        return ResponseEntity.status(200).body(coursesService.getFailedCourses());
    }

    @GetMapping("/course-requierment")
    public ResponseEntity getCourseRequierment(){
        return ResponseEntity.status(200).body(coursesService.getCoursesRequierments());
    }


}
