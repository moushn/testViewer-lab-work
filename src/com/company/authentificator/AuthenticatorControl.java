package com.company.authentificator;

import com.company.authentificator.interfaces.AuthenticatorServiceInt;

import java.util.Optional;

public class AuthenticatorControl implements com.company.authentificator.interfaces.AuthenticatorControlInt {
    private final AuthenticatorServiceInt authenticatorService;

    public AuthenticatorControl(AuthenticatorServiceInt authenticatorService) {
        this.authenticatorService = authenticatorService;
    }

    @Override
    public Optional<Session> authenticateUser(String login) {
        return authenticatorService.authenticateUser(login);
    }

    @Override
    public boolean logout(Session session) {
        return authenticatorService.logout(session);
    }
}
