package com.example.lab7.Service;

import ch.qos.logback.core.CoreConstants;
import com.example.lab7.Model.Courses;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CoursesService {
    ArrayList<Courses> courses = new ArrayList<>();

    public ArrayList<Courses> getCourses(){
        return courses;
    }

    public void addCourse(Courses course){
        courses.add(course);
    }

    public boolean updateCourse(String id, Courses course){
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId().equalsIgnoreCase(id)){
                courses.set(i, course);
                return true;
            }
        }
        return false;
    }

    public Courses deleteCourse(String id){
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId().equalsIgnoreCase(id)){
                courses.remove(i);
            }
        }
        return null;
    }


    //give me 4 methods more, that contains logic!


    //method to get course by it's id!
    public Courses getCourseById(String id){
        for (Courses course : courses){
            if (course.getCourseId().equalsIgnoreCase(id)){
                return course;
            }
        }
        return null;
    }

    //method to check if the course exist!
    public boolean courseExists(String id){
        for (Courses course : courses){
            if (course.getCourseId().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }
    //method to get all passed courses
    public ArrayList<Courses> passCourses(){
        ArrayList<Courses> passCourse = new ArrayList<>();
        for (Courses course : courses){
            if (course.isPass()){
                passCourse.add(course);
            }
        }
        return passCourse;
    }

    //method to get all courses that not passed !
    public ArrayList<Courses> getFailedCourses(){
        ArrayList<Courses> failedCourses = new ArrayList<>();
        for (Courses course : courses){
            if (!course.isPass()){
                failedCourses.add(course);
            }
        }
        return failedCourses;
    }



    //method to get all courses that meet requierment
    public ArrayList<Courses> getCoursesRequierments(){
        ArrayList<Courses> courseRequierment = new ArrayList<>();
        for (Courses course : courses){
            if (course.isCourseRequierments()){
                courseRequierment.add(course);
            }
        }
        return courseRequierment;
    }

}
