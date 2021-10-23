package com.company.menu.interfaces;

import com.company.bd.model.TestEdPresent;
import com.company.bd.model.TestEdResultsPresent;
import com.company.bd.model.UserRolesPresent;

import java.util.List;
import java.util.Optional;

public interface MenuRepositoryInt {
    Optional<List<UserRolesPresent>> getUserRolesList();

    Optional<List<TestEdPresent>> getTestEdPresentListByUserId(int userId);

    Optional<List<TestEdResultsPresent>> getTestEdResultsPresentListByUserId(int userId);
}
