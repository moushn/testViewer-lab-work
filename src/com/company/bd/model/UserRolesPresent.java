package com.company.bd.model;

import com.company.bd.model.entities.Role;
import com.company.bd.model.entities.User;

import java.util.List;

public class UserRolesPresent {
    private final User user;
    private final List<Role> roles;

    public UserRolesPresent(User user, List<Role> roles) {
        this.user = user;
        this.roles = roles;
    }

    public User getUser() {
        return user;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
