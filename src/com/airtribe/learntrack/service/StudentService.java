package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class StudentService {
    private StudentRepository studentRepository;
    private Scanner scanner;

    public StudentService() {
        studentRepository = new StudentRepository();
        scanner =  new Scanner(System.in);
    }

    public void addStudent(){
        Student student = new Student();
        student.setId(IdGenerator.getNextStudentId());
        System.out.println("Enter the first name");
        student.setFirstName(scanner.nextLine());
        System.out.println("Enter the last name");
        student.setLastName(scanner.nextLine());
        System.out.println("Enter the email");
        student.setEmail(scanner.nextLine());

        studentRepository.addStudent(student);
        System.out.println("Student has been added successfully");
    }

    public void viewAllStudent() {
        ArrayList<Student> students =  studentRepository.getStudents();
        System.out.println("List of students");
        System.out.println("================");
        for(Student s: students) {
            displayStudentDetails(s);
        }
    }

    private static void displayStudentDetails(Student s) {
        System.out.println("Id : "+ s.getId());
        System.out.println("Name : "+ s.getDisplayName());
        System.out.println("Email : "+ s.getEmail());
        System.out.println("Active : "+ s.isActive());
        System.out.println();
    }

    public void searchStudent() {
        try {
            Student student = findStudentById();
            System.out.println("Student found:");
            displayStudentDetails(student);
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private Student findStudentById() throws EntityNotFoundException {
        System.out.println("Enter student id");
        int id = scanner.nextInt();
        ArrayList<Student> students =  studentRepository.getStudents();
        Optional<Student> student = students.stream().filter(s->s.getId() == id).findAny();
        if (student.isPresent()) {
            return student.get();
        }
        throw new EntityNotFoundException("Student not found with id: " + id);
    }

    public void deactivateStudent() {
        try {
            Student student = findStudentById();
            if (student.isActive()){
                student.setActive(false);
                System.out.println("Student deactivation done!");
            } else {
                System.out.println("Student is already inactive!");
            }
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}