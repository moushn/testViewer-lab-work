package com.company.bd.model.entities;

public class MethodRoleRelation {
    private final int methodId;
    private final int roleId;

    public MethodRoleRelation(int methodId, int roleId) {
        this.methodId = methodId;
        this.roleId = roleId;
    }

    public int getMethodId() {
        return methodId;
    }

    public int getRoleId() {
        return roleId;
    }
}
