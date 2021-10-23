package com.company.bd.model.entities;

public class Method {
    private final int methodId;
    private final String name;

    public Method(int methodId, String name) {
        this.methodId = methodId;
        this.name = name;
    }

    public int getMethodId() {
        return methodId;
    }

    public String getName() {
        return name;
    }
}
