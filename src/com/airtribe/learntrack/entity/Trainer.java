package com.airtribe.learntrack.entity;

public class Trainer extends Person{
    private int experienseInYears;

    public Trainer(String firstName, String lastName, String email, int experienseInYears) {
        super(firstName, lastName, email);
        this.experienseInYears = experienseInYears;
    }

    public int getExperienseInYears() {
        return experienseInYears;
    }

    public void setExperienseInYears(int experienseInYears) {
        this.experienseInYears = experienseInYears;
    }
}
