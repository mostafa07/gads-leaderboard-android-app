package com.example.gads.leaderboard.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gads.leaderboard.data.model.ProjectSubmission;
import com.example.gads.leaderboard.data.repository.ProjectSubmissionRepository;

import rx.Observable;

public class ProjectSubmissionViewModel extends ViewModel {

    private static final String LOG_TAG = ProjectSubmissionViewModel.class.getSimpleName();

    private ProjectSubmissionRepository mProjectSubmissionRepository;
    private MutableLiveData<ProjectSubmission> mProjectSubmissionMutableLiveData;
    private MutableLiveData<Boolean> mIsProjectSubmittedSuccessfullyMutableLiveData;

    public ProjectSubmissionViewModel() {
        mProjectSubmissionRepository = ProjectSubmissionRepository.getInstance();
        mProjectSubmissionMutableLiveData = new MutableLiveData<>(new ProjectSubmission());
        mIsProjectSubmittedSuccessfullyMutableLiveData = new MutableLiveData<>();
    }


    public void submitProjectSubmission() {
        validateProjectSubmission().subscribe(isValid -> {
            if (isValid) {
                final ProjectSubmission projectSubmission = mProjectSubmissionMutableLiveData.getValue();
                mProjectSubmissionRepository.postProjectSubmission(projectSubmission.getFirstName(),
                        projectSubmission.getLastName(), projectSubmission.getEmail(),
                        projectSubmission.getProjectLink()).subscribe(isPostedSuccessfully -> {
                    if (isPostedSuccessfully) {
                        mIsProjectSubmittedSuccessfullyMutableLiveData.setValue(true);
                        mProjectSubmissionMutableLiveData.setValue(new ProjectSubmission());
                    } else {
                        mIsProjectSubmittedSuccessfullyMutableLiveData.setValue(false);
                    }
                }, throwable -> {
                    throwable.printStackTrace();
                    mIsProjectSubmittedSuccessfullyMutableLiveData.setValue(false);
                });
            } else {
                mIsProjectSubmittedSuccessfullyMutableLiveData.setValue(false);
            }
        }, throwable -> {
            throwable.printStackTrace();
            mIsProjectSubmittedSuccessfullyMutableLiveData.setValue(false);
        });
    }


    // Validations

    private Observable<Boolean> validateProjectSubmission() {
        final ProjectSubmission projectSubmission = mProjectSubmissionMutableLiveData.getValue();
        return Observable.create(subscriber -> {
            if (projectSubmission == null) {
                subscriber.onNext(false);
            } else if (projectSubmission.getFirstName() == null || projectSubmission.getFirstName().isEmpty()) {
                subscriber.onNext(false);
            } else if (projectSubmission.getLastName() == null || projectSubmission.getLastName().isEmpty()) {
                subscriber.onNext(false);
            } else if (projectSubmission.getEmail() == null || projectSubmission.getEmail().isEmpty()) {
                subscriber.onNext(false);
            } else if (projectSubmission.getProjectLink() == null || projectSubmission.getProjectLink().isEmpty()) {
                subscriber.onNext(false);
            } else {
                subscriber.onNext(true);
            }
        });
    }


    // Getters and Setters

    public LiveData<ProjectSubmission> getProjectSubmissionLiveData() {
        return mProjectSubmissionMutableLiveData;
    }

    public LiveData<Boolean> getIsProjectSubmittedSuccessfullyLiveData() {
        return mIsProjectSubmittedSuccessfullyMutableLiveData;
    }
}
