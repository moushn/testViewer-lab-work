package com.company.bd.tables;

import com.company.bd.model.entities.UserRoleRelation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRoleRelationTable {
    private static final List<UserRoleRelation> userRoleRelationTable = new ArrayList<>(Arrays.asList(
            new UserRoleRelation(1, 1),
            new UserRoleRelation(2, 3),
            new UserRoleRelation(3, 3),
            new UserRoleRelation(4, 2),
            new UserRoleRelation(5, 2)
    ));

    public static Optional<List<Integer>> getRoleIdListByUserId(int userId) {
        return Optional.ofNullable(userRoleRelationTable.stream()
                .filter(urr -> urr.getUserId() == userId)
                .map(UserRoleRelation::getRoleId)
                .collect(Collectors.toList())
                );
    }

    public static Optional<List<Integer>> getRoleIdListByUserIdList(List<Integer> userIds) {
        return Optional.ofNullable(userRoleRelationTable.stream()
                .filter(urr -> userIds.contains(urr.getUserId()))
                .map(UserRoleRelation::getRoleId)
                .collect(Collectors.toList())
        );
    }
}
