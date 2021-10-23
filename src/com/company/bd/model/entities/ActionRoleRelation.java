package com.company.bd.model.entities;

public class ActionRoleRelation {
    private final int actionId;
    private final int roleId;

    public ActionRoleRelation(int actionId, int roleId) {
        this.actionId = actionId;
        this.roleId = roleId;
    }

    public int getActionId() {
        return actionId;
    }

    public int getRoleId() {
        return roleId;
    }
}
