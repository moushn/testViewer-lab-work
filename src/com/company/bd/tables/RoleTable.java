package com.company.bd.tables;

import com.company.bd.model.entities.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoleTable {
    public static final List<Role> roleTable = new ArrayList<>(Arrays.asList(
            new Role(1, "admin"),
            new Role(2, "student"),
            new Role(3, "teacher")
    ));

    public static Optional<List<Role>> getRoleListByRoleIdList(List<Integer> roleIds) {
        return Optional.ofNullable(roleTable.stream()
                .filter(r -> roleIds.contains(r.getRoleId()))
                .collect(Collectors.toList())
                );
    }
}
