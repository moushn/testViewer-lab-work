package com.company.menu.interfaces;

import com.company.authentificator.Session;
import com.company.bd.model.TestEdPresent;
import com.company.bd.model.TestEdResultsPresent;
import com.company.bd.model.UserRolesPresent;
import com.company.bd.model.entities.Action;

import java.util.List;
import java.util.Optional;

public interface MenuControlInt {
    Optional<List<Action>> getAvailableActionsBySession(Session session);

    Boolean logout(Session session);

    Optional<List<UserRolesPresent>> getUserList(Session session);

    Optional<List<TestEdPresent>> getTestEdPresentList(Session session);

    Optional<List<TestEdResultsPresent>> getTestEdResultsPresentList(Session session);
}
