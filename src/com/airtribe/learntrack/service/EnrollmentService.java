package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnrollmentService {
    private EnrollmentRepository enrollmentRepository;
    private Scanner scanner;

    public EnrollmentService() {
        enrollmentRepository = new EnrollmentRepository();
        scanner = new Scanner(System.in);
    }

    public void enrollStudent() {
        System.out.println("Enter student id");
        int studentId = scanner.nextInt();
        System.out.println("Enter course id");
        int courseId = scanner.nextInt();
        scanner.nextLine();

        Enrollment enrollment = new Enrollment(studentId, courseId, new Date(), EnrollmentStatus.ACTIVE);
        enrollment.setId(IdGenerator.getNextEnrollmentId());
        enrollmentRepository.addEnrollment(enrollment);
        System.out.println("Student enrolled successfully");
    }

    public void viewEnrollmentsByStudent() {
        System.out.println("Enter student id");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Enrollment> enrollments = enrollmentRepository.getEnrollments();
        ArrayList<Enrollment> studentEnrollments = enrollments.stream()
                .filter(e -> e.getStudentId() == studentId)
                .collect(Collectors.toCollection(ArrayList::new));

        if (studentEnrollments.isEmpty()) {
            System.out.println("No enrollments found for this student");
        } else {
            System.out.println("Enrollments for student " + studentId);
            System.out.println("================");
            for (Enrollment e : studentEnrollments) {
                displayEnrollmentDetails(e);
            }
        }
    }

    private static void displayEnrollmentDetails(Enrollment e) {
        System.out.println("Id : " + e.getId());
        System.out.println("Student Id : " + e.getStudentId());
        System.out.println("Course Id : " + e.getCourseId());
        System.out.println("Enrollment Date : " + e.getEnrollmentDate());
        System.out.println("Status : " + e.getStatus());
        System.out.println();
    }

    public void markEnrollmentCompleted() {
        try {
            Enrollment enrollment = findEnrollmentById();
            if (enrollment.getStatus() == EnrollmentStatus.ACTIVE) {
                enrollment.setStatus(EnrollmentStatus.COMPLETED);
                System.out.println("Enrollment marked as completed!");
            } else {
                System.out.println("Enrollment is not active. Current status: " + enrollment.getStatus());
            }
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void markEnrollmentCancelled() {
        try {
            Enrollment enrollment = findEnrollmentById();
            if (enrollment.getStatus() == EnrollmentStatus.ACTIVE) {
                enrollment.setStatus(EnrollmentStatus.CANCELLED);
                System.out.println("Enrollment marked as cancelled!");
            } else {
                System.out.println("Enrollment is not active. Current status: " + enrollment.getStatus());
            }
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private Enrollment findEnrollmentById() throws EntityNotFoundException {
        System.out.println("Enter enrollment id");
        int id = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Enrollment> enrollments = enrollmentRepository.getEnrollments();
        Optional<Enrollment> enrollment = enrollments.stream().filter(e -> e.getId() == id).findAny();
        if (enrollment.isPresent()) {
            return enrollment.get();
        }
        throw new EntityNotFoundException("Enrollment not found with id: " + id);
    }
}


