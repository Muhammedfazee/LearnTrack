package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;

import java.util.ArrayList;

public class EnrollmentRepository {
    private ArrayList<Enrollment> enrollments;

    public EnrollmentRepository() {
        this.enrollments = new ArrayList<>();
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public ArrayList<Enrollment> getEnrollments() {
        return this.enrollments;
    }
}
