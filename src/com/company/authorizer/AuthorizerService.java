package com.company.authorizer;

import com.company.authentificator.Session;
import com.company.authorizer.interfaces.AuthorizerRepositoryInt;
import com.company.authorizer.interfaces.AuthorizerServiceInt;
import com.company.bd.model.entities.Action;

import java.util.List;
import java.util.Optional;

public class AuthorizerService implements AuthorizerServiceInt {
    private final AuthorizerRepositoryInt authorizerRepository;

    public AuthorizerService(AuthorizerRepositoryInt authorizerRepository) {
        this.authorizerRepository = authorizerRepository;
    }

    @Override
    public Optional<List<Action>> getAvailableActionsBySession(Session session) {
        return authorizerRepository.getAvailableActionsBySession(session);
    }

    @Override
    public boolean checkAvailabilityMethodBySession(Session session, String requestedMethodName) {
        return authorizerRepository.checkAvailabilityMethodBySession(session, requestedMethodName);
    }
}
