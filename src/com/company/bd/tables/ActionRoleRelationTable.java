package com.company.bd.tables;

import com.company.bd.model.entities.ActionRoleRelation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ActionRoleRelationTable {
    private static final List<ActionRoleRelation> actionRoleRelationTable = new ArrayList<>(Arrays.asList(
            new ActionRoleRelation(1, 2),
            new ActionRoleRelation(2, 3),
            new ActionRoleRelation(3, 1),
            new ActionRoleRelation(4, -1)
    ));

    public static Optional<List<Integer>> getPublicActionsId() {
        return Optional.ofNullable(actionRoleRelationTable.stream()
                .filter(arr -> arr.getRoleId() == -1)
                .map(ActionRoleRelation::getActionId)
                .collect(Collectors.toList()));
    }

    public static Optional<List<Integer>> getActionsIdByRoleIdList(List<Integer> roleIds) {
        return Optional.ofNullable(actionRoleRelationTable.stream()
                .filter(arr -> roleIds.contains(arr.getRoleId()) || arr.getRoleId() == -1) //мб юзать мапу для оптимизации поиска, если конвертация в мапу не дороже этого поиска
                .map(ActionRoleRelation::getActionId)
                .collect(Collectors.toList()));
    }
}
