package com.example.gads.leaderboard.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.gads.leaderboard.R;
import com.example.gads.leaderboard.databinding.ActivityLeaderboardBinding;
import com.example.gads.leaderboard.ui.adapter.FragmentPageAdapter;
import com.example.gads.leaderboard.ui.viewmodel.LeaderboardViewModel;
import com.google.android.material.tabs.TabLayoutMediator;

public class LeaderboardActivity extends AppCompatActivity {

    private static final String LOG_TAG = LeaderboardActivity.class.getSimpleName();

    private ActivityLeaderboardBinding mBinding;
    private LeaderboardViewModel mLeaderboardViewModel;

    FragmentPageAdapter mFragmentPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_leaderboard);
        mLeaderboardViewModel = new ViewModelProvider(this).get(LeaderboardViewModel.class);
        mBinding.setViewModel(mLeaderboardViewModel);
        mBinding.setLifecycleOwner(this);

        setupViewPager();

        setupViewModelObservations();

        setupButtons();
    }

    private void setupViewPager() {
        mFragmentPageAdapter = new FragmentPageAdapter(this);
        mBinding.viewPager.setAdapter(mFragmentPageAdapter);

        new TabLayoutMediator(mBinding.tabLayout, mBinding.viewPager, (tab, position) -> {
            if (position == 0) {
                tab.setText(R.string.learning_leaders);
            } else if (position == 1) {
                tab.setText(R.string.skill_iq_leaders);
            }
        }).attach();
    }

    private void setupViewModelObservations() {

    }

    private void setupButtons() {
        mBinding.appBarLayout.submitButton.setOnClickListener(view -> {
            startActivity(new Intent(LeaderboardActivity.this, ProjectSubmissionActivity.class));
        });
    }
}