package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.InputValidator;

import java.util.Scanner;

public class Main {

    private StudentService studentService = new StudentService();
    private CourseService courseService = new CourseService();
    private EnrollmentService enrollmentService = new EnrollmentService();
    private Scanner sc = new Scanner(System.in);

    private int readStudentId() {
        System.out.println("Enter student id");
        return InputValidator.validateNumber(sc.nextLine());
    }

    private int readCourseId() {
        System.out.println("Enter course id");
        return InputValidator.validateNumber(sc.nextLine());
    }

    private int readEnrollmentId() {
        System.out.println("Enter enrollment id");
        return InputValidator.validateNumber(sc.nextLine());
    }

    private void addStudent() {
        System.out.println("Enter the first name");
        String firstName = sc.nextLine();
        System.out.println("Enter the last name");
        String lastName = sc.nextLine();
        System.out.println("Enter the email");
        String email = sc.nextLine();
        studentService.addStudent(firstName, lastName, email);
    }

    private void addCourse() {
        System.out.println("Enter the course name");
        String courseName = sc.nextLine();
        System.out.println("Enter the description");
        String description = sc.nextLine();
        System.out.println("Enter the duration in weeks");
        int durationInWeeks = InputValidator.validateNumber(sc.nextLine());
        if (durationInWeeks == -1) return;
        courseService.addCourse(courseName, description, durationInWeeks);
    }

    private void addEnrollment() {
        int studentId = readStudentId();
        if (studentId == -1) return;
        int courseId = readCourseId();
        if (courseId == -1) return;
        enrollmentService.enrollStudent(studentId, courseId);
    }

    private void searchStudent() {
        int id = readStudentId();
        if (id == -1) return;
        studentService.searchStudent(id);
    }

    private void deactivateStudent() {
        int id = readStudentId();
        if (id == -1) return;
        studentService.deactivateStudent(id);
    }

    private void activateCourse() {
        int id = readCourseId();
        if (id == -1) return;
        courseService.activateCourse(id);
    }

    private void deactivateCourse() {
        int id = readCourseId();
        if (id == -1) return;
        courseService.deactivateCourse(id);
    }

    private void viewEnrollmentsByStudent() {
        int studentId = readStudentId();
        if (studentId == -1) return;
        enrollmentService.viewEnrollmentsByStudent(studentId);
    }

    private void markEnrollmentCompleted() {
        int id = readEnrollmentId();
        if (id == -1) return;
        enrollmentService.markEnrollmentCompleted(id);
    }

    private void markEnrollmentCancelled() {
        int id = readEnrollmentId();
        if (id == -1) return;
        enrollmentService.markEnrollmentCancelled(id);
    }

    private void studentManagement() {
        int option;
        do{
            System.out.println("Student management");
            System.out.println("====================");
            System.out.println("1. Add new student");
            System.out.println("2. View all students");
            System.out.println("3. Search student by ID");
            System.out.println("4. Deactivate student");
            System.out.println("5. Main menu");
            System.out.println("Please select an option : ");
            String input = sc.nextLine();
            option = InputValidator.validateNumber(input);

            switch (option) {
                case MenuOptions.ADD_STUDENT :
                    addStudent();
                    break;
                case MenuOptions.VIEW_ALL_STUDENTS:
                    studentService.viewAllStudent();
                    break;
                case MenuOptions.SEARCH_STUDENT:
                    searchStudent();
                    break;
                case MenuOptions.DEACTIVATE_STUDENT:
                    deactivateStudent();
                    break;
                case MenuOptions.STUDENT_BACK:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != MenuOptions.STUDENT_BACK);
    }

    private void courseManagement() {
        int option;
        do {
            System.out.println("Course management");
            System.out.println("====================");
            System.out.println("1. Add new course");
            System.out.println("2. View all courses");
            System.out.println("3. Activate course");
            System.out.println("4. Deactivate course");
            System.out.println("5. Main menu");
            System.out.println("Please select an option : ");
            String input = sc.nextLine();
            option = InputValidator.validateNumber(input);

            switch (option) {
                case MenuOptions.ADD_COURSE:
                    addCourse();
                    break;
                case MenuOptions.VIEW_ALL_COURSES:
                    courseService.viewAllCourses();
                    break;
                case MenuOptions.ACTIVATE_COURSE:
                    activateCourse();
                    break;
                case MenuOptions.DEACTIVATE_COURSE:
                    deactivateCourse();
                    break;
                case MenuOptions.COURSE_BACK:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != MenuOptions.COURSE_BACK);
    }

    private void enrollmentManagement() {
        int option;
        do {
            System.out.println("Enrollment management");
            System.out.println("====================");
            System.out.println("1. Enroll a student in a course");
            System.out.println("2. View enrollments for a student");
            System.out.println("3. Mark enrollment as completed");
            System.out.println("4. Mark enrollment as cancelled");
            System.out.println("5. Main menu");
            System.out.println("Please select an option : ");
            String input = sc.nextLine();
            option = InputValidator.validateNumber(input);

            switch (option) {
                case MenuOptions.ENROLL_STUDENT:
                    addEnrollment();
                    break;
                case MenuOptions.VIEW_ENROLLMENTS_BY_STUDENT:
                    viewEnrollmentsByStudent();
                    break;
                case MenuOptions.MARK_ENROLLMENT_COMPLETED:
                    markEnrollmentCompleted();
                    break;
                case MenuOptions.MARK_ENROLLMENT_CANCELLED:
                    markEnrollmentCancelled();
                    break;
                case MenuOptions.ENROLLMENT_BACK:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != MenuOptions.ENROLLMENT_BACK);
    }

    private void run() {
        int option;
        do {
            System.out.println("Menu");
            System.out.println("====================");
            System.out.println("1. Student management");
            System.out.println("2. Course management");
            System.out.println("3. Enrollment management");
            System.out.println("4. Exit");
            System.out.println("Please select an option : ");
            String input = sc.nextLine();
            option = InputValidator.validateNumber(input);

            switch (option) {
                case MenuOptions.STUDENT_MANAGEMENT:
                    studentManagement();
                    break;
                case MenuOptions.COURSE_MANAGEMENT:
                    courseManagement();
                    break;
                case MenuOptions.ENROLLMENT_MANAGEMENT:
                    enrollmentManagement();
                    break;
                case MenuOptions.EXIT:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        while (option != MenuOptions.EXIT);
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }
}
