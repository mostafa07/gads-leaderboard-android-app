package com.example.gads.leaderboard.data.repository;

import com.example.gads.leaderboard.webservice.ProjectSubmissionGoogleFormWebService;
import com.example.gads.leaderboard.webservice.builder.GoogleFormRetrofitServiceBuilder;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;

public class ProjectSubmissionRepository {

    private static final String LOG_TAG = ProjectSubmissionRepository.class.getSimpleName();

    private static ProjectSubmissionRepository sProjectSubmissionRepository;
    private ProjectSubmissionGoogleFormWebService mProjectSubmissionGoogleFormWebService;

    private ProjectSubmissionRepository() {
        mProjectSubmissionGoogleFormWebService =
                GoogleFormRetrofitServiceBuilder.buildService(ProjectSubmissionGoogleFormWebService.class);
    }

    public static ProjectSubmissionRepository getInstance() {
        synchronized (LeaderboardRepository.class) {
            if (sProjectSubmissionRepository == null) {
                sProjectSubmissionRepository = new ProjectSubmissionRepository();
            }
            return sProjectSubmissionRepository;
        }
    }


    public Observable<Boolean> postProjectSubmission(String firstName, String lastName, String email, String projectLink) {
        return Observable.create(subscriber -> {
            mProjectSubmissionGoogleFormWebService.submitProjectForm(firstName, lastName, email, projectLink)
                    .enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(@NotNull Call<Void> call, @NotNull Response<Void> response) {
                            if (response.isSuccessful()) {
                                subscriber.onNext(true);
                            }
                        }

                        @Override
                        public void onFailure(@NotNull Call<Void> call, @NotNull Throwable t) {
                            subscriber.onNext(false);
                            subscriber.onError(t);
                        }
                    });
        });
    }
}
