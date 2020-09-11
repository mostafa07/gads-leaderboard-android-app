package com.example.gads.leaderboard.ui.adapter;

import com.example.gads.leaderboard.BR;
import com.example.gads.leaderboard.R;
import com.example.gads.leaderboard.data.model.SkillIqProfile;
import com.example.gads.leaderboard.ui.adapter.base.BaseRecyclerViewAdapter;

public class SkillIqProfileAdapter extends BaseRecyclerViewAdapter<SkillIqProfile> {

    public SkillIqProfileAdapter() {
        super();
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_skill_iq_profile;
    }

    @Override
    protected int getViewBindingVariableId() {
        return BR.profile;
    }
}
