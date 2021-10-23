package com.company.authorizer;

import com.company.authentificator.Session;
import com.company.authorizer.interfaces.AuthorizerControlInt;
import com.company.authorizer.interfaces.AuthorizerServiceInt;
import com.company.bd.model.entities.Action;

import java.util.List;
import java.util.Optional;

public class AuthorizerControl implements AuthorizerControlInt {
    private final AuthorizerServiceInt authorizerService;

    public AuthorizerControl(AuthorizerServiceInt authorizerService) {
        this.authorizerService = authorizerService;
    }

    @Override
    public Optional<List<Action>> getAvailableActionsBySession(Session session) {
        return authorizerService.getAvailableActionsBySession(session);
    }

    @Override
    public boolean checkAvailabilityMethodBySession(Session session, String requestedMethodName) {
        return authorizerService.checkAvailabilityMethodBySession(session, requestedMethodName);
    }
}
