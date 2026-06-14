package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.Optional;

public class CourseService {
    private CourseRepository courseRepository;

    public CourseService() {
        courseRepository = new CourseRepository();
    }

    public void addCourse(String courseName, String description, int durationInWeeks) {
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

    public void activateCourse(int id) {
        try {
            Course course = findCourseById(id);
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

    public void deactivateCourse(int id) {
        try {
            Course course = findCourseById(id);
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

    private Course findCourseById(int id) throws EntityNotFoundException {
        ArrayList<Course> courses = courseRepository.getCourses();
        Optional<Course> course = courses.stream().filter(c -> c.getId() == id).findAny();
        if (course.isPresent()) {
            return course.get();
        }
        throw new EntityNotFoundException("Course not found with id: " + id);
    }
}

