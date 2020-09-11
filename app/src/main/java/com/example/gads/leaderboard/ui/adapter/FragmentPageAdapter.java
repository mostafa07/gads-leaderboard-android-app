package com.example.gads.leaderboard.ui.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.gads.leaderboard.ui.fragment.PageFragment;

public class FragmentPageAdapter extends FragmentStateAdapter {

    public FragmentPageAdapter(AppCompatActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        final Fragment fragment = new PageFragment();
        final Bundle args = new Bundle();
        args.putInt(PageFragment.ARG_OBJECT, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}