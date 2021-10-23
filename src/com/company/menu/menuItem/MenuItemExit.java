package com.company.menu.menuItem;

import com.company.authentificator.Session;
import com.company.bd.model.entities.Action;
import com.company.menu.interfaces.MenuControlInt;

public class MenuItemExit extends MenuItemAbstract {
    public MenuItemExit(Action action) {
        super(action);
    }

    @Override
    public boolean execute(MenuControlInt menuControl, Session session) {
        System.out.println("Сеанс завершен");
        return menuControl.logout(session);
    }

}
