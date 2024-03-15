package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model.Student;
import com.example.lab7.Service.StudentSerivce;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentSerivce studentSerivce;

    @GetMapping("/get")
    public ArrayList<Student> getStudents(){
        return studentSerivce.getStudents();
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentSerivce.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("student added successfully!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @RequestBody @Valid Student student, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentSerivce.updateStudent(id, student);
        return ResponseEntity.status(200).body(new ApiResponse("student updated successfully!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id){
        studentSerivce.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("student deleted successfully!"));
    }

    //write more 4 methods and all must be a logic !!!

    @GetMapping("/get-student/{id}")
    public ResponseEntity getStudentById(@PathVariable int id){
        return ResponseEntity.status(200).body(studentSerivce.getStudentById(id));
    }

    @GetMapping("/student-with-same-course/{courseId}")
    public ResponseEntity getStudentWithSameCourse(@PathVariable String courseId){
        ArrayList<Student> students = studentSerivce.getStudentsWithSameCourse(courseId);
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/get-student-by-hours/{hours}")
    public ResponseEntity getStudentByHoursEarnd(@PathVariable int hours){
        ArrayList<Student> result = studentSerivce.getStudentByHoursEarnd(hours);
        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/student-gpa/{GPA}")
    public ResponseEntity getStudentWithGPA(@PathVariable double GPA){
        ArrayList<Student> studentGPA = studentSerivce.getStudentWithGPA(GPA);
        return ResponseEntity.status(200).body(studentGPA);
    }

    @GetMapping("/get-average-gpa")
    public ResponseEntity getAverageGpa(){
        return ResponseEntity.status(200).body(studentSerivce.averageGpa());
    }
}
