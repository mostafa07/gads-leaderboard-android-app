package com.example.gads.leaderboard.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gads.leaderboard.R;
import com.example.gads.leaderboard.ui.dialog.SuccessDialog;

public class LeaderboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        showSuccessDialog();
    }

    private void showSuccessDialog() {
        SuccessDialog successDialog = SuccessDialog.newInstance();
        successDialog.show(getSupportFragmentManager(), LeaderboardActivity.class.getSimpleName());
    }
}