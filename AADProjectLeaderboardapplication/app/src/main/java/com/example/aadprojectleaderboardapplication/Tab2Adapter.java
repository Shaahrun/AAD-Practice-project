package com.example.aadprojectleaderboardapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Tab2Adapter extends RecyclerView.Adapter<Tab2Adapter.Tab2ViewHolder> {
    private ArrayList<SkillLeadersInfo> mLeaders;
    private LayoutInflater mLayoutInflater;

    public Tab2Adapter (Context context, ArrayList<SkillLeadersInfo> leaders) {
        mLayoutInflater = LayoutInflater.from(context);
        mLeaders = leaders;
    }
    @NonNull
    @Override
    public Tab2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_skill_iq, parent, false);

        return new Tab2ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Tab2ViewHolder holder, int position) {
        SkillLeadersInfo skillLeadersInfo = mLeaders.get(position);
        holder.bind(skillLeadersInfo);
    }

    @Override
    public int getItemCount() {
        return mLeaders.size();
    }

    public class Tab2ViewHolder extends RecyclerView.ViewHolder {
        TextView mLearnerName;
        TextView mSkillIq;
        TextView mCountry;

        public Tab2ViewHolder(@NonNull View itemView) {
            super(itemView);
            mLearnerName = (TextView) itemView.findViewById(R.id.text_skill_leaders_name);
            mSkillIq = (TextView) itemView.findViewById(R.id.text_skill_iq);
            mCountry = (TextView) itemView.findViewById(R.id.text_skill_leaders_country);
        }
        public void bind(SkillLeadersInfo leadersInfo) {
            mLearnerName.setText(leadersInfo.getName());
            mSkillIq.setText(leadersInfo.getSkillIq());
            mCountry.setText(leadersInfo.getCountry());
        }
    }
}
