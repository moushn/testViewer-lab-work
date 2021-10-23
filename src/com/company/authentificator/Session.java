package com.company.authentificator;

public class Session {
    private final int userId;

    public Session(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
}
