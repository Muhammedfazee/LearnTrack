package com.airtribe.learntrack;

import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.InputValidator;

import java.util.Scanner;

public class Main {

    public static void studentManagement() {
        StudentService studentService = new StudentService();
        Scanner sc = new Scanner(System.in);
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
            option = InputValidator.validateMenuOption(input);

            switch (option) {
                case MenuOptions.ADD_STUDENT :
                    studentService.addStudent();
                    break;
                case MenuOptions.VIEW_ALL_STUDENTS:
                    studentService.viewAllStudent();
                    break;
                case MenuOptions.SEARCH_STUDENT:
                    studentService.searchStudent();
                    break;
                case MenuOptions.DEACTIVATE_STUDENT:
                    studentService.deactivateStudent();
                    break;
                case MenuOptions.STUDENT_BACK:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != MenuOptions.STUDENT_BACK);
    }

    public static void courseManagement() {
        CourseService courseService = new CourseService();
        Scanner sc = new Scanner(System.in);
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
            option = InputValidator.validateMenuOption(input);

            switch (option) {
                case MenuOptions.ADD_COURSE:
                    courseService.addCourse();
                    break;
                case MenuOptions.VIEW_ALL_COURSES:
                    courseService.viewAllCourses();
                    break;
                case MenuOptions.ACTIVATE_COURSE:
                    courseService.activateCourse();
                    break;
                case MenuOptions.DEACTIVATE_COURSE:
                    courseService.deactivateCourse();
                    break;
                case MenuOptions.COURSE_BACK:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != MenuOptions.COURSE_BACK);
    }

    public static void enrollmentManagement() {
        EnrollmentService enrollmentService = new EnrollmentService();
        Scanner sc = new Scanner(System.in);
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
            option = InputValidator.validateMenuOption(input);

            switch (option) {
                case MenuOptions.ENROLL_STUDENT:
                    enrollmentService.enrollStudent();
                    break;
                case MenuOptions.VIEW_ENROLLMENTS_BY_STUDENT:
                    enrollmentService.viewEnrollmentsByStudent();
                    break;
                case MenuOptions.MARK_ENROLLMENT_COMPLETED:
                    enrollmentService.markEnrollmentCompleted();
                    break;
                case MenuOptions.MARK_ENROLLMENT_CANCELLED:
                    enrollmentService.markEnrollmentCancelled();
                    break;
                case MenuOptions.ENROLLMENT_BACK:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != MenuOptions.ENROLLMENT_BACK);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
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
            option = InputValidator.validateMenuOption(input);

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
}
