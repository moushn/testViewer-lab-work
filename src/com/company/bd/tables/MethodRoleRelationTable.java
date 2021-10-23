package com.company.bd.tables;

import com.company.bd.model.entities.MethodRoleRelation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MethodRoleRelationTable {
    private static final List<MethodRoleRelation> methodRoleRelationTable = new ArrayList<>(Arrays.asList(
            new MethodRoleRelation(1, 1),
            new MethodRoleRelation(2, 2),
            new MethodRoleRelation(3, 3)
    ));

    public static Optional<List<Integer>> getMethodIdListByRoleId(List<Integer> roles) {
        return Optional.ofNullable(methodRoleRelationTable.stream()
                .filter(rel -> roles.contains(rel.getRoleId()))
                .map(MethodRoleRelation::getMethodId)
                .collect(Collectors.toList())
        );
    }
}
