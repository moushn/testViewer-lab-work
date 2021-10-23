package com.company.bd.tables;

import com.company.bd.model.entities.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserTable {
    private static final List<User> userTable = new ArrayList<>(Arrays.asList(
            new User(1, "admin"),
            new User(2, "teacher1"),
            new User(3, "teacher2"),
            new User(4, "student1"),
            new User(5, "student2")
    ));

    public static Optional<User> getUserByLogin(String login) {
        return userTable.stream()
                .filter(u -> u.getLogin().equals(login))
                .findAny();
    }

    public static Optional<User> getUserByUserId(int userId) {
        return userTable.stream()
                .filter(u -> u.getUserId() == userId)
                .findAny();
    }

    public static Optional<List<User>> getUsers() {
        return Optional.ofNullable(userTable);
    }
}
