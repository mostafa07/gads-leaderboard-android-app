package com.example.gads.leaderboard.data.model.app;

public class Message {

    private int messageResourceId;
    private Object[] params;

    public Message(int messageResourceId, Object... params) {
        this.messageResourceId = messageResourceId;
        this.params = params;
    }

    public int getMessageResourceId() {
        return messageResourceId;
    }

    public void setMessageResourceId(int messageResourceId) {
        this.messageResourceId = messageResourceId;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
