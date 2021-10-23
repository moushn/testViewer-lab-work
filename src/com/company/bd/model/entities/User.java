package com.company.bd.model.entities;

public class User {
    private final int userId;
    private final String login;

    public User(int userId, String login) {
        this.userId = userId;
        this.login = login;
    }

    public int getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }
}
