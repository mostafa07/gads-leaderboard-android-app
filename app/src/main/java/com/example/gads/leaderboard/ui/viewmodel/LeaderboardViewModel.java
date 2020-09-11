package com.example.gads.leaderboard.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gads.leaderboard.data.model.LearningHoursProfile;
import com.example.gads.leaderboard.data.model.SkillIqProfile;
import com.example.gads.leaderboard.data.repository.LeaderboardRepository;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardViewModel extends ViewModel {

    private static final String LOG_TAG = LeaderboardViewModel.class.getSimpleName();

    private LeaderboardRepository mLeaderboardRepository;
    private MutableLiveData<List<LearningHoursProfile>> mLearningHoursProfileListMutableLiveData;
    private MutableLiveData<List<SkillIqProfile>> mSkillIqProfileListMutableLiveData;


    public LeaderboardViewModel() {
        mLeaderboardRepository = LeaderboardRepository.getInstance();

        mLearningHoursProfileListMutableLiveData = new MutableLiveData<>();
        mSkillIqProfileListMutableLiveData = new MutableLiveData<>();

        getLearningHoursProfiles();
        getSkillIqProfiles();
    }


    public void getLearningHoursProfiles() {
        mLeaderboardRepository.getLearningHoursProfiles().subscribe(learningHoursProfiles -> {
            mLearningHoursProfileListMutableLiveData.setValue(learningHoursProfiles);
        }, Throwable::printStackTrace);
    }

    public void getSkillIqProfiles() {
        mLeaderboardRepository.getSkillIqProfiles().subscribe(skillIqProfiles -> {
            mSkillIqProfileListMutableLiveData.setValue(skillIqProfiles);
        }, Throwable::printStackTrace);
    }


    // Getters and Setters

    public LiveData<List<LearningHoursProfile>> getLearningHoursProfileListLiveData() {
        return mLearningHoursProfileListMutableLiveData;
    }

    public LiveData<List<SkillIqProfile>> getSkillIqProfileListLiveData() {
        return mSkillIqProfileListMutableLiveData;
    }
}
