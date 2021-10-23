package com.company.bd.model.entities;

public class Role {
    private final int roleId;
    private final String name;

    public Role(int roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }
}
