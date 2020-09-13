package com.example.gads.leaderboard.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.gads.leaderboard.R;
import com.example.gads.leaderboard.databinding.ActivityProjectSubmissionBinding;
import com.example.gads.leaderboard.ui.dialog.ErrorDialog;
import com.example.gads.leaderboard.ui.dialog.SuccessDialog;
import com.example.gads.leaderboard.ui.viewmodel.ProjectSubmissionViewModel;

public class ProjectSubmissionActivity extends AppCompatActivity {

    private static final String LOG_TAG = ProjectSubmissionActivity.class.getSimpleName();

    private ActivityProjectSubmissionBinding mBinding;
    private ProjectSubmissionViewModel mProjectSubmissionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_project_submission);
        mProjectSubmissionViewModel = new ViewModelProvider(this).get(ProjectSubmissionViewModel.class);
        mBinding.setViewModel(mProjectSubmissionViewModel);
        mBinding.setLifecycleOwner(this);

        setupViewModelObservations();

        setupButtons();
    }


    private void setupViewModelObservations() {
        mProjectSubmissionViewModel.getIsProjectSubmittedSuccessfullyLiveData().observe(this, isSubmitted -> {
            if (isSubmitted) {
                showSuccessDialog();
            } else {
                showErrorDialog();
            }
        });
    }

    private void setupButtons() {
        mBinding.submitButton.setOnClickListener(view -> mProjectSubmissionViewModel.submitProjectSubmission());
    }


    private void showSuccessDialog() {
        final SuccessDialog successDialog = SuccessDialog.newInstance();
        successDialog.show(getSupportFragmentManager(), LeaderboardActivity.class.getSimpleName());
    }

    private void showErrorDialog() {
        final ErrorDialog errorDialog = ErrorDialog.newInstance();
        errorDialog.show(getSupportFragmentManager(), LeaderboardActivity.class.getSimpleName());
    }
}