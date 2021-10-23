package com.company.menu;

import com.company.authentificator.Session;
import com.company.authentificator.interfaces.AuthenticatorControlInt;
import com.company.authorizer.interfaces.AuthorizerControlInt;
import com.company.bd.model.TestEdPresent;
import com.company.bd.model.TestEdResultsPresent;
import com.company.bd.model.UserRolesPresent;
import com.company.bd.model.entities.Action;
import com.company.menu.interfaces.MenuControlInt;
import com.company.menu.interfaces.MenuServiceInt;

import java.util.List;
import java.util.Optional;

public class MenuControl implements MenuControlInt {
    private final AuthorizerControlInt authorizerControl;
    private final MenuServiceInt menuService;
    private final AuthenticatorControlInt authenticatorControl;

    public MenuControl(AuthorizerControlInt authorizerControl, MenuServiceInt menuService, AuthenticatorControlInt authenticatorControl) {
        this.authorizerControl = authorizerControl;
        this.menuService = menuService;
        this.authenticatorControl = authenticatorControl;
    }

    @Override
    public Optional<List<Action>> getAvailableActionsBySession(Session session) {
        return authorizerControl.getAvailableActionsBySession(session);
    }

    @Override
    public Boolean logout(Session session) {
        return authenticatorControl.logout(session);
    }

    @Override
    public Optional<List<UserRolesPresent>> getUserList(Session session) {
        String requestedMethodName = getRequestedMethodName();
        if (!authorizerControl.checkAvailabilityMethodBySession(session, requestedMethodName)) {
            return Optional.empty();
        }
        return menuService.getUserRolesList();
    }

    private String getRequestedMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    @Override
    public Optional<List<TestEdPresent>> getTestEdPresentList(Session session) {
        String requestedMethodName = getRequestedMethodName();
        if (!authorizerControl.checkAvailabilityMethodBySession(session, requestedMethodName)) {
            return Optional.empty();
        }
        return menuService.getTestEdPresentListByUserId(session.getUserId());
    }

    @Override
    public Optional<List<TestEdResultsPresent>> getTestEdResultsPresentList(Session session) {
        String requestedMethodName = getRequestedMethodName();
        if (!authorizerControl.checkAvailabilityMethodBySession(session, requestedMethodName)) {
            return Optional.empty();
        }
        return menuService.getTestEdResultsPresentListByUserId(session.getUserId());
    }
}
