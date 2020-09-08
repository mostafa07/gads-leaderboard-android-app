package com.example.gads.leaderboard.data.model;

public class SkillIqProfile {

    private String name;
    private String country;
    private String badgeUrl;
    private Integer score;

    public SkillIqProfile() {
    }

    public SkillIqProfile(String name, String country, String badgeUrl, Integer score) {
        this.name = name;
        this.country = country;
        this.badgeUrl = badgeUrl;
        this.score = score;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
