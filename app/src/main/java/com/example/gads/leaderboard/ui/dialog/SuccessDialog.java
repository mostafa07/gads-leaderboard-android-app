package com.example.gads.leaderboard.ui.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.example.gads.leaderboard.R;
import com.example.gads.leaderboard.data.model.app.Message;
import com.example.gads.leaderboard.databinding.FragmentDialogSuccessBinding;

public class SuccessDialog extends DialogFragment {

    private static final String LOG_TAG = SuccessDialog.class.getSimpleName();
    private static final String MESSAGE_BUNDLE_KEY = "msg";

    private FragmentDialogSuccessBinding mBinding;
    private Message mMessage;

    public SuccessDialog() {
    }

    public static SuccessDialog newInstance(String... messageStr) {
        SuccessDialog successDialog = new SuccessDialog();
        if (messageStr.length > 0) {
            final Bundle args = new Bundle();
            args.putString(MESSAGE_BUNDLE_KEY, messageStr[0]);
        }
        return successDialog;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mMessage = new Message(R.string.submission_successful, getArguments().getString(MESSAGE_BUNDLE_KEY));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dialog_success, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (mMessage != null) {
            mBinding.setMessage(mMessage);
        }
    }
}
