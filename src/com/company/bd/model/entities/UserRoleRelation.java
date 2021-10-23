package com.company.bd.model.entities;

public class UserRoleRelation {
    private final int userId;
    private final int roleId;

    public UserRoleRelation(int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public int getRoleId() {
        return roleId;
    }
}
