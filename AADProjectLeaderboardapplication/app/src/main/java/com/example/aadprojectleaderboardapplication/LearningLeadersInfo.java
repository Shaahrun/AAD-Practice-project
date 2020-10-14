package com.example.aadprojectleaderboardapplication;

public final class LearningLeadersInfo {
        private String mName;
        private String mLearningHours;
        private String mCountry;

    public LearningLeadersInfo(String name, String learningHours, String country) {
        mName = name;
        mLearningHours = learningHours;
        mCountry = country;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getLearningHours() {
        return mLearningHours;
    }

    public void setLearningHours(String learningHours) {
        mLearningHours = learningHours;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }
}
