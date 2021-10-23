package com.company.authentificator;

import com.company.authentificator.interfaces.AuthenticatorRepositoryInt;

import java.util.Optional;

public class AuthenticatorService implements com.company.authentificator.interfaces.AuthenticatorServiceInt {
    private final AuthenticatorRepositoryInt authenticatorRepository;

    public AuthenticatorService(AuthenticatorRepositoryInt authenticatorRepository) {
        this.authenticatorRepository = authenticatorRepository;
    }

    @Override
    public Optional<Session> authenticateUser(String login) {
        return authenticatorRepository.authenticateUser(login);
    }

    @Override
    public boolean logout(Session session) {
        return authenticatorRepository.logout(session);
    }
}
