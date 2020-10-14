package com.example.aadprojectleaderboardapplication;

public final class SkillLeadersInfo {
    private String mName;
    private String mSkillIq;
    private String mCountry;

    public SkillLeadersInfo(String name, String skillIq, String country) {
        mName = name;
        mSkillIq = skillIq;
        mCountry = country;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSkillIq() {
        return mSkillIq;
    }

    public void setSkillIq(String skillIq) {
        mSkillIq = skillIq;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }
}
