package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model.Student;
import com.example.lab7.Model.Teacher;
import com.example.lab7.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ArrayList<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added successfully!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id, @RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(200).body(message);
        }
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher updated successfully!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher deleted successfully!"));
    }

    @GetMapping("/get-teacher/{id}")
    public ResponseEntity getTeacher(@PathVariable int id){
        return ResponseEntity.status(200).body(teacherService.getTeacher(id));
    }

    @GetMapping("/search-by-subject/{subject}")
    public ResponseEntity getTeacherBySubject(@PathVariable String subject){
        return ResponseEntity.status(200).body(teacherService.getTeacherBySubject(subject));
    }



    @GetMapping("/teacher/{id}/students")
    public ResponseEntity getTeacherStudents(@PathVariable int id){
        Teacher teacher = teacherService.getTeacher(id);
        if (teacher == null){
            return ResponseEntity.status(400).body(new ApiResponse("teacher not found!"));
        }
        List<Student> students = teacher.getStudents();
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/teacher/{id}/average-gpa")
    public ResponseEntity getAverageGpa(@PathVariable int id) {
        Teacher teacher = teacherService.getTeacher(id);
        if (teacher == null) {
            return ResponseEntity.status(400).body(new ApiResponse("Not found!"));
        }
        double averageGpa = teacherService.getAverageGpa(teacher);
        return ResponseEntity.status(200).body(averageGpa);
    }






}
