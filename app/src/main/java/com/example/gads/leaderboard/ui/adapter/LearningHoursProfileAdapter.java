package com.example.gads.leaderboard.ui.adapter;

import com.example.gads.leaderboard.BR;
import com.example.gads.leaderboard.R;
import com.example.gads.leaderboard.data.model.LearningHoursProfile;
import com.example.gads.leaderboard.ui.adapter.base.BaseRecyclerViewAdapter;

public class LearningHoursProfileAdapter extends BaseRecyclerViewAdapter<LearningHoursProfile> {

    public LearningHoursProfileAdapter() {
        super();
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_learning_hours_profile;
    }

    @Override
    protected int getViewBindingVariableId() {
        return BR.profile;
    }
}
