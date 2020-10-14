package com.example.aadprojectleaderboardapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    FragmentManager mFragmentManager = getSupportFragmentManager();
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    private ViewPagerAdapter mViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager2 = findViewById(R.id.view_pager);
        mViewPager2.setAdapter(mViewPagerAdapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0: {
                        tab.setText(R.string.tab_label1);
                        break;
                    }
                    case 1: {
                        tab.setText(R.string.tab_label2);
                        break;
                    }
                }
            }
        }
        );
        tabLayoutMediator.attach();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DataApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DataApi dataApi = retrofit.create(DataApi.class);

        Call<List<LearningLeadersInfo>> callLearners = dataApi.getLearningLeaders();
        Call<List<SkillLeadersInfo>> callSkills = dataApi.getSkillLeaders();

        callLearners.enqueue(new Callback<List<LearningLeadersInfo>>() {
            @Override
            public void onResponse(Call<List<LearningLeadersInfo>> call, Response<List<LearningLeadersInfo>> response) {
                List<LearningLeadersInfo> leadersInfos = response.body();

                String[] leadersDetails = new String[leadersInfos.size()];
                for (int i = 0; i < leadersInfos.size(); i++) {
                    for (int j = 0; j < leadersInfos.size(); j++) {
                        for (int k = 0; k < leadersInfos.size(); k++) {
                            leadersDetails[i] = leadersInfos.get(i).getName();
                            leadersDetails[j] = leadersInfos.get(j).getLearningHours();
                            leadersDetails[k] = leadersInfos.get(k).getCountry();
                        }
                    }

                }


            }

            @Override
            public void onFailure(Call<List<LearningLeadersInfo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        callSkills.enqueue(new Callback<List<SkillLeadersInfo>>() {
            @Override
            public void onResponse(Call<List<SkillLeadersInfo>> call, Response<List<SkillLeadersInfo>> response) {
                List<SkillLeadersInfo> skillLeadersInfos = response.body();
            }

            @Override
            public void onFailure(Call<List<SkillLeadersInfo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}