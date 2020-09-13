package com.example.gads.leaderboard.webservice;

import com.example.gads.leaderboard.common.ApiEndPoints;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProjectSubmissionGoogleFormWebService {

    @POST(ApiEndPoints.GOOGLE_FORM_URL)
    @FormUrlEncoded
    Call<Void> submitProjectForm(@Field(ApiEndPoints.NAME_ENTRY_ID) String firstName,
                                 @Field(ApiEndPoints.LAST_NAME_ENTRY_ID) String lastName,
                                 @Field(ApiEndPoints.EMAIL_ENTRY_ID) String email,
                                 @Field(ApiEndPoints.LINK_TO_PROJECT_ENTRY_ID) String projectLink);
}
