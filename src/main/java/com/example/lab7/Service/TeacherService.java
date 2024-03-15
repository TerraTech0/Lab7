package com.example.lab7.Service;

import com.example.lab7.Model.Student;
import com.example.lab7.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getTeachers(){
        return teachers;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public boolean updateTeacher(int id, Teacher teacher){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getTeacherId() == id){
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }
    public Teacher deleteTeacher(int id){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getTeacherId() == id){
                teachers.remove(i);
            }
        }
        return null;
    }


    //add 4 more methods, all logic

    //search teacher by id
    public Teacher getTeacher(int id){
        for (Teacher teacher : teachers){
            if (teacher.getTeacherId() == id){
                return teacher;
            }
        }
        return null;
    }

    // Method to get teachers by subject
    public Teacher getTeacherBySubject(String subject){
        for (Teacher teacher : teachers){
            if (teacher.getSubject().equalsIgnoreCase(subject)){
                return teacher;
            }
        }
        return null;
    }

    //get teacher's students
    public int getTeacherStudents(Teacher teacher){
        return teacher.getStudents().size();
    }

    //get the average GPA of a teacher's students
    public double getAverageGpa(Teacher teacher){
        if (teacher.getStudents().isEmpty()){
            return 0.0;
        }
        double totalGPA = 0.0;
        for (Student student : teacher.getStudents()){
            totalGPA += student.getGPA();
        }
        return totalGPA / teacher.getStudents().size();
    }


}
