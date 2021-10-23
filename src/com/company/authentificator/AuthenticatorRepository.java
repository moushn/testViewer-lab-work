package com.company.authentificator;

import com.company.authentificator.interfaces.AuthenticatorRepositoryInt;
import com.company.bd.tables.UserTable;

import java.util.Optional;

public class AuthenticatorRepository implements AuthenticatorRepositoryInt {
    @Override
    public Optional<Session> authenticateUser(String login) {
        return UserTable.getUserByLogin(login)
                .map(u -> new Session(u.getUserId()));
    }

    @Override
    public boolean logout(Session session) {
        //выключить сессию в бд
        return true;
    }
}
