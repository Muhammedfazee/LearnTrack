package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;

import java.util.ArrayList;

public class StudentRepository {
    private ArrayList<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }
     public ArrayList<Student> getStudents(){
        return this.students;
     }
}
