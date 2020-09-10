package com.example.gads.leaderboard.common.exception;

import com.example.gads.leaderboard.data.model.app.Message;

public class BusinessException {

    private Message message;

    public BusinessException(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
