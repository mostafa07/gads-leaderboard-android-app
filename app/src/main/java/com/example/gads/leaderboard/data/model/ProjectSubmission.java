package com.example.gads.leaderboard.data.model;

import java.io.Serializable;

public class ProjectSubmission implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String projectLink;

    public ProjectSubmission() {
    }

    public ProjectSubmission(String firstName, String lastName, String email, String projectLink) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.projectLink = projectLink;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }
}
