package com.company.authorizer.interfaces;

import com.company.authentificator.Session;
import com.company.bd.model.entities.Action;

import java.util.List;
import java.util.Optional;

public interface AuthorizerControlInt {
    Optional<List<Action>> getAvailableActionsBySession(Session session);

    boolean checkAvailabilityMethodBySession(Session session, String requestedMethodName);
}
