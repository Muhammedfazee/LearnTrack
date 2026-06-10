package com.airtribe.learntrack.constants;

public final class MenuOptions {

    private MenuOptions() {
        // prevent instantiation
    }

    // Main Menu
    public static final int STUDENT_MANAGEMENT = 1;
    public static final int COURSE_MANAGEMENT = 2;
    public static final int ENROLLMENT_MANAGEMENT = 3;
    public static final int EXIT = 4;

    //Student Management
    public static final int ADD_STUDENT = 1;
    public static final int VIEW_ALL_STUDENTS = 2;
    public static final int SEARCH_STUDENT = 3;
    public static final int DEACTIVATE_STUDENT = 4;
    public static final int STUDENT_BACK = 5;

    //Course Management
    public static final int ADD_COURSE = 1;
    public static final int VIEW_ALL_COURSES = 2;
    public static final int ACTIVATE_COURSE = 3;
    public static final int DEACTIVATE_COURSE = 4;
    public static final int COURSE_BACK = 5;

    //Enrollment Management
    public static final int ENROLL_STUDENT = 1;
    public static final int VIEW_ENROLLMENTS_BY_STUDENT = 2;
    public static final int MARK_ENROLLMENT_COMPLETED = 3;
    public static final int MARK_ENROLLMENT_CANCELLED = 4;
    public static final int ENROLLMENT_BACK = 5;

}