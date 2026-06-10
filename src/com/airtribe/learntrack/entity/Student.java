package com.airtribe.learntrack.entity;

public class Student extends Person{
    private String batch;
    private boolean active;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, String batch, boolean active) {
        super(firstName, lastName, email);
        this.batch = batch;
        this.active = active;
    }
    public Student(String firstName, String lastName, String batch, boolean active) {
        super(firstName, lastName, "email");
        this.batch = batch;
        this.active = active;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDisplayName(){
        return this.getFirstName()+"_"+this.getLastName();
    }
}
