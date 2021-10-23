package com.company.bd.model.entities;

public class Action {
    private final int actionId;
    private final String title;
    private final String action;

    public Action(int actionId, String action, String title) {
        this.actionId = actionId;
        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public String getAction() {
        return action;
    }

    public int getActionId() {
        return actionId;
    }
}
