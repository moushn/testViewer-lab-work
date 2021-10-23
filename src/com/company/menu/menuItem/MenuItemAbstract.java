package com.company.menu.menuItem;

import com.company.authentificator.Session;
import com.company.bd.model.entities.Action;
import com.company.menu.interfaces.MenuControlInt;

public abstract class MenuItemAbstract {
    private final Action action;

    public MenuItemAbstract(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return action;
    }

    public abstract boolean execute(MenuControlInt menuControl, Session session);
}
