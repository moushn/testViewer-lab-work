package com.company.menu.menuItem;

import com.company.authentificator.Session;
import com.company.bd.model.UserRolesPresent;
import com.company.bd.model.entities.Action;
import com.company.bd.model.entities.Role;
import com.company.menu.interfaces.MenuControlInt;

import java.util.List;
import java.util.Optional;

public class MenuItemUsers extends MenuItemAbstract {
    public MenuItemUsers(Action action) {
        super(action);
    }

    @Override
    public boolean execute(MenuControlInt menuControl, Session session) {
        Optional<List<UserRolesPresent>> users = menuControl.getUserList(session);
        if (users.isEmpty() || users.get().isEmpty()) {
            System.out.println("Пользователи отсутствуют или у вас нет прав на их просмотр");
            return false;
        }
        printUserRolesPresentList(users.get());
        return false;
    }

    private void printUserRolesPresentList(List<UserRolesPresent> users) {
        for (UserRolesPresent user : users) {
            System.out.println("-----------------------------------------------");
            System.out.println("Пользователь: " + user.getUser().getLogin());
            System.out.println("Роли пользователя");
            for (Role role : user.getRoles()) {
                System.out.println(role.getName());
            }
            System.out.println("-----------------------------------------------");
        }
    }
}
