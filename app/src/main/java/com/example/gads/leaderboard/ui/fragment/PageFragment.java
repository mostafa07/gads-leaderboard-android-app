package com.example.gads.leaderboard.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.gads.leaderboard.R;
import com.example.gads.leaderboard.databinding.FragmentPageBinding;
import com.example.gads.leaderboard.ui.adapter.LearningHoursProfileAdapter;
import com.example.gads.leaderboard.ui.adapter.SkillIqProfileAdapter;
import com.example.gads.leaderboard.ui.viewmodel.LeaderboardViewModel;

public class PageFragment extends Fragment {

    private static final String LOG_TAG = PageFragment.class.getSimpleName();

    private FragmentPageBinding mBinding;
    private LeaderboardViewModel mLeaderboardViewModel;

    private LearningHoursProfileAdapter mLearningHoursProfileAdapter;
    private SkillIqProfileAdapter mSkillIqProfileAdapter;

    public static final String ARG_OBJECT = "object";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_page, container, false);
        mBinding.setLifecycleOwner(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mLearningHoursProfileAdapter = new LearningHoursProfileAdapter(dataItem -> {
            Log.d(LOG_TAG, "On Learning Hours Profile Item Clicked");
        });
        mSkillIqProfileAdapter = new SkillIqProfileAdapter(dataItem -> {
            Log.d(LOG_TAG, "On Skill IQ Profile Item Clicked");
        });

        final Bundle args = getArguments();
        final int position = args.getInt(ARG_OBJECT);

        if (position == 0) {
            mBinding.pageRecyclerView.setAdapter(mLearningHoursProfileAdapter);
        } else if (position == 1) {
            mBinding.pageRecyclerView.setAdapter(mSkillIqProfileAdapter);
        }

        setupViewModel();
    }


    private void setupViewModel() {
        mLeaderboardViewModel = new ViewModelProvider(requireActivity()).get(LeaderboardViewModel.class);
        mLeaderboardViewModel.getLearningHoursProfileListLiveData().observe(requireActivity(),
                learningHoursProfiles -> mLearningHoursProfileAdapter.setDataList(learningHoursProfiles));
        mLeaderboardViewModel.getSkillIqProfileListLiveData().observe(requireActivity(),
                skillIqProfiles -> mSkillIqProfileAdapter.setDataList(skillIqProfiles));
    }
}
