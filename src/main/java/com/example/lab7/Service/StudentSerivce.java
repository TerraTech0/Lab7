package com.example.lab7.Service;

import com.example.lab7.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentSerivce {

    ArrayList<Student> students = new ArrayList<>();


    //Get all students !
    public ArrayList<Student> getStudents() {
        return students;
    }

    //add new student !
    public void addStudent(Student student){
        students.add(student);
    }

    //update students
    public Student updateStudent(int id, Student student){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == id){
                students.set(i, student);
            }
        }
        return null;
    }

    //to delete student
    public Student deleteStudent(int id){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == id){
                students.remove(i);
            }
        }
        return null;
    }


    //write more 4 methods that have a logic!

    //get student by id!
    public Student getStudentById(int id){
        for (Student student : students){
            if (student.getStudentId() == id){
                return student;
            }
        }
        return null;
    }

    //get students by course id
    public ArrayList<Student> getStudentsWithSameCourse(String courseId){
        ArrayList<Student> studentsWithSameCourse = new ArrayList<>();
        for (Student student : students){
            if (student.getCourseId().equalsIgnoreCase(courseId)){
                studentsWithSameCourse.add(student);
            }
        }
        return studentsWithSameCourse;
    }

    // Method to get students who have earned more than a certain number of hours
    public ArrayList<Student> getStudentByHoursEarnd(int hours){
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students){
            if (student.getHoursEarnd() > hours){
                result.add(student);
            }
        }
        return result;
    }

    // Method to get students who have a GPA above a certain threshold
    public ArrayList<Student> getStudentWithGPA(double GPA){
        ArrayList<Student> studentWithGPA = new ArrayList<>();
        for (Student student : students){
            if (student.getGPA() >= GPA){
                studentWithGPA.add(student);
            }
        }
        return studentWithGPA;
    }

    public double averageGpa(){
        if (students.isEmpty()){
            return 0.0;
        }
        double totalGPA = 0.0;
        for (Student student : students){
            totalGPA = totalGPA + student.getGPA();
        }
        return totalGPA/students.size();
    }


}
