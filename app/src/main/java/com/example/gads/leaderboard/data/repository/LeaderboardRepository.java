package com.example.gads.leaderboard.data.repository;

import com.example.gads.leaderboard.data.model.LearningHoursProfile;
import com.example.gads.leaderboard.data.model.SkillIqProfile;
import com.example.gads.leaderboard.webservice.LeaderboardWebService;
import com.example.gads.leaderboard.webservice.builder.RetrofitServiceBuilder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;

public class LeaderboardRepository {

    private static final String LOG_TAG = LeaderboardRepository.class.getSimpleName();

    private static LeaderboardRepository sLeaderboardRepository;
    private LeaderboardWebService mLeaderboardWebService;

    private LeaderboardRepository() {
        mLeaderboardWebService = RetrofitServiceBuilder.buildService(LeaderboardWebService.class);
    }

    public static LeaderboardRepository getInstance() {
        synchronized (LeaderboardRepository.class) {
            if (sLeaderboardRepository == null) {
                sLeaderboardRepository = new LeaderboardRepository();
            }
            return sLeaderboardRepository;
        }
    }


    public Observable<List<LearningHoursProfile>> getLearningHoursProfiles() {
        return Observable.create(subscriber -> {
            mLeaderboardWebService.getLearningHoursProfiles().enqueue(new Callback<List<LearningHoursProfile>>() {
                @Override
                public void onResponse(@NotNull Call<List<LearningHoursProfile>> call,
                                       @NotNull Response<List<LearningHoursProfile>> response) {
                    if (response.isSuccessful()) {
                        subscriber.onNext(response.body());
                    }
                }

                @Override
                public void onFailure(Call<List<LearningHoursProfile>> call, Throwable t) {
                    subscriber.onError(t);
                }
            });
            subscriber.onCompleted();
        });
    }

    public Observable<List<SkillIqProfile>> getSkillIqProfiles() {
        return Observable.create(subscriber -> {
            mLeaderboardWebService.getSkillIqProfiles().enqueue(new Callback<List<SkillIqProfile>>() {
                @Override
                public void onResponse(@NotNull Call<List<SkillIqProfile>> call,
                                       @NotNull Response<List<SkillIqProfile>> response) {
                    if (response.isSuccessful()) {
                        subscriber.onNext(response.body());
                    }
                }

                @Override
                public void onFailure(Call<List<SkillIqProfile>> call, Throwable t) {
                    subscriber.onError(t);
                }
            });
            subscriber.onCompleted();
        });
    }
}
