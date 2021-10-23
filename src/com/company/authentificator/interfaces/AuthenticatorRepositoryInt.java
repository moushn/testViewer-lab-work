package com.company.authentificator.interfaces;

import com.company.authentificator.Session;

import java.util.Optional;

public interface AuthenticatorRepositoryInt {
    Optional<Session> authenticateUser(String login);

    boolean logout(Session session);
}
