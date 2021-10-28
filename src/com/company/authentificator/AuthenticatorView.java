package com.company.authentificator;

import com.company.authentificator.interfaces.AuthenticatorControlInt;

import java.util.Optional;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class AuthenticatorView {
    private final AuthenticatorControlInt authenticatorControl;
    private Session session;

    public AuthenticatorView(AuthenticatorControlInt authenticatorControl) {
        this.authenticatorControl = authenticatorControl;
    }

    public Session authenticateUser() {
        boolean isAuthenticatedUser;
        System.out.println("Введите имя пользователя");

        //TODO логику повторной аутентификации надо вынести наружу, а метод, должен кидать исключение, в случае если
        // аутентификация не удалась
        try {
            Scanner scanner = new Scanner(System.in);
            do {
                int resultCode = authenticateUser(scanner.nextLine().trim());
                isAuthenticatedUser = checkResultAuthenticateUser(resultCode);
                if (!isAuthenticatedUser) {
                    System.out.println("Введенное имя некорректно. Введите корректное имя пользователя");
                }
            }
            while (!isAuthenticatedUser);
            //scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.session;
    }

    private int authenticateUser(String login) {
        Optional<Session> newSession = authenticatorControl.authenticateUser(login);
        newSession.ifPresent(s -> this.session = s);
        return newSession.isPresent() ? 0 : 1;
    }

    private boolean checkResultAuthenticateUser(int resultCode) {
        return resultCode == 0;
    }
}
