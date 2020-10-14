package com.example.aadprojectleaderboardapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Tab1Adapter extends RecyclerView.Adapter<Tab1Adapter.Tab1ViewHolder> {
    private ArrayList<LearningLeadersInfo> mLeaders;
    private LayoutInflater mLayoutInflater;

    public Tab1Adapter (Context context, ArrayList<LearningLeadersInfo> leaders) {
        mLayoutInflater = LayoutInflater.from(context);
        mLeaders = leaders;
    }

    @NonNull
    @Override
    public Tab1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_learning_leaders, parent, false);

        return new Tab1ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Tab1ViewHolder holder, int position) {
        LearningLeadersInfo leadersInfo = mLeaders.get(position);
        holder.bind(leadersInfo);

    }

    @Override
    public int getItemCount() {
        return mLeaders.size();
    }

    public class Tab1ViewHolder extends RecyclerView.ViewHolder {
        TextView mLearnerName;
        TextView mLearningHours;
        TextView mCountry;

        public Tab1ViewHolder(@NonNull View itemView) {
            super(itemView);
            mLearnerName = (TextView) itemView.findViewById(R.id.text_learner_name);
            mLearningHours = (TextView) itemView.findViewById(R.id.text_learning_hours);
            mCountry = (TextView) itemView.findViewById(R.id.text_learners_country);
        }
        public void bind(LearningLeadersInfo leadersInfo) {
            mLearnerName.setText(leadersInfo.getName());
            mLearningHours.setText(leadersInfo.getLearningHours());
            mCountry.setText(leadersInfo.getCountry());
        }
    }

}
