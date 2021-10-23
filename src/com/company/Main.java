package com.company;

import com.company.authentificator.*;
import com.company.authentificator.interfaces.*;
import com.company.authorizer.interfaces.AuthorizerControlInt;
import com.company.authorizer.AuthorizerControl;
import com.company.authorizer.AuthorizerRepository;
import com.company.authorizer.AuthorizerService;
import com.company.authorizer.interfaces.AuthorizerRepositoryInt;
import com.company.authorizer.interfaces.AuthorizerServiceInt;
import com.company.menu.*;
import com.company.menu.interfaces.*;

public class Main {
    private final static AuthenticatorView authenticatorView;
    private final static AuthenticatorControlInt authenticatorControl;
    private final static MenuControlInt menuControl;
    private final static AuthenticatorRepositoryInt authenticatorRepository;
    private final static AuthenticatorServiceInt authenticatorService;
    private final static AuthorizerRepositoryInt authorizerRepository;
    private final static AuthorizerServiceInt authorizerService;
    private final static MenuRepositoryInt menuRepository;
    private final static MenuServiceInt menuService;
    private final static AuthorizerControlInt authorizerControl;

    static {
        authorizerRepository = new AuthorizerRepository();
        authenticatorRepository = new AuthenticatorRepository();
        menuRepository = new MenuRepository();
        authorizerService = new AuthorizerService(authorizerRepository);
        authenticatorService = new AuthenticatorService(authenticatorRepository);
        menuService = new MenuService(menuRepository);
        authenticatorControl = new AuthenticatorControl(authenticatorService);
        authorizerControl = new AuthorizerControl(authorizerService);
        menuControl = new MenuControl(authorizerControl, menuService, authenticatorControl);
        authenticatorView = new AuthenticatorView(authenticatorControl);
    }

    public static void main(String[] args) {
        Session session = authenticatorView.authenticateUser();
        MenuView menuView = new MenuView(session, menuControl);
        menuView.run();
    }

}
