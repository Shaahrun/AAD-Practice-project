package com.example.aadprojectleaderboardapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataApi {
    public static final String BASE_URL = "https://gadsapi.herokuapp.com";
    public static final String LEARNING_LEADERS_KEY = "/api/hours";
    public static final String SKILL_IQ_LEADERS_KEY = "/api/skilliq";

    @GET(LEARNING_LEADERS_KEY)
    Call<List<LearningLeadersInfo>> getLearningLeaders();

    @GET(SKILL_IQ_LEADERS_KEY)
    Call<List<SkillLeadersInfo>> getSkillLeaders();
}
