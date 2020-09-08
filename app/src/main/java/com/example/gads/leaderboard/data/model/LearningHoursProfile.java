package com.example.gads.leaderboard.data.model;

import java.io.Serializable;

public class LearningHoursProfile implements Serializable {

    private String name;
    private String country;
    private String badgeUrl;
    private Integer hours;

    public LearningHoursProfile() {
    }

    public LearningHoursProfile(String name, String country, String badgeUrl, Integer hours) {
        this.name = name;
        this.country = country;
        this.badgeUrl = badgeUrl;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
}
