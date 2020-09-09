package com.example.gads.leaderboard.webservice.builder;

import com.example.gads.leaderboard.common.ApiEndPoints;
import com.example.gads.leaderboard.data.model.LearningHoursProfile;
import com.example.gads.leaderboard.data.model.SkillIqProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeaderboardWebService {

    @GET(ApiEndPoints.LEARNING_LEADERS_END_POINT)
    Call<List<LearningHoursProfile>> getLearningHoursProfiles();

    @GET(ApiEndPoints.SKILL_IQ_LEADERS_END_POINT)
    Call<List<SkillIqProfile>> getSkillIqProfiles();
}
