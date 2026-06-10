package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class CourseService {
    private CourseRepository courseRepository;
    private Scanner scanner;

    public CourseService() {
        courseRepository = new CourseRepository();
        scanner = new Scanner(System.in);
    }

    public void addCourse() {
        System.out.println("Enter the course name");
        String courseName = scanner.nextLine();
        System.out.println("Enter the description");
        String description = scanner.nextLine();
        System.out.println("Enter the duration in weeks");
        int durationInWeeks = scanner.nextInt();
        scanner.nextLine();

        Course course = new Course(courseName, description, durationInWeeks, true);
        course.setId(IdGenerator.getNextCourseId());
        courseRepository.addCourse(course);
        System.out.println("Course has been added successfully");
    }

    public void viewAllCourses() {
        ArrayList<Course> courses = courseRepository.getCourses();
        System.out.println("List of courses");
        System.out.println("================");
        for (Course c : courses) {
            displayCourseDetails(c);
        }
    }

    private static void displayCourseDetails(Course c) {
        System.out.println("Id : " + c.getId());
        System.out.println("Name : " + c.getCourseName());
        System.out.println("Description : " + c.getDescription());
        System.out.println("Duration : " + c.getDurationInWeeks() + " weeks");
        System.out.println("Active : " + c.isActive());
        System.out.println();
    }

    public void activateCourse() {
        try {
            Course course = findCourseById();
            if (!course.isActive()) {
                course.setActive(true);
                System.out.println("Course activation done!");
            } else {
                System.out.println("Course is already active!");
            }
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deactivateCourse() {
        try {
            Course course = findCourseById();
            if (course.isActive()) {
                course.setActive(false);
                System.out.println("Course deactivation done!");
            } else {
                System.out.println("Course is already inactive!");
            }
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private Course findCourseById() throws EntityNotFoundException {
        System.out.println("Enter course id");
        int id = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Course> courses = courseRepository.getCourses();
        Optional<Course> course = courses.stream().filter(c -> c.getId() == id).findAny();
        if (course.isPresent()) {
            return course.get();
        }
        throw new EntityNotFoundException("Course not found with id: " + id);
    }
}

