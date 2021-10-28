package com.company.menu;

import com.company.authentificator.Session;
import com.company.bd.model.entities.Action;
import com.company.menu.interfaces.MenuControlInt;
import com.company.menu.menuItem.*;

import java.util.*;
import java.util.stream.Collectors;

import static com.company.menu.menuItem.ActionTypes.*;

public class MenuView {
    private boolean isFinish;
    private List<MenuItemAbstract> menuItems;
    private final Session session;
    private final MenuControlInt menuControl;

    public MenuView(Session session, MenuControlInt menuControl) {
        this.menuControl = menuControl;
        this.session = session;
    }

    public void run() {
        int numberChosenMenuItem;
        MenuItemAbstract menuItem;
        int resultCode = requestMenuItems();
        //TODO должен делать бек-енд
        if (!checkResultRequestMenuItems(resultCode)) {
            this.menuItems.add(new MenuItemExit(new Action(4, "EXIT", "Выход")));
        }
        // в отдельный метод
        try {
            // TODO в пропертях инжектится OutputStream и в конструкторе он сетится, а в методе уже берется из филда
            Scanner scanner = new Scanner(System.in);
            while (!isFinish) {
                try {
                    // TODO в пропертях инжектится OutputStream и в конструкторе он сетится, а в методе уже берется из филда
                    printMenu();
                    numberChosenMenuItem = Integer.parseInt(scanner.nextLine());
                    // TODO убрать
                    if (!checkChosenMenuItem(numberChosenMenuItem)) {
                        continue;
                    }
                    // TODO обработать выход за границы листа отдельно
                    menuItem = menuItems.get(numberChosenMenuItem - 1);
                    isFinish = menuItem.execute(menuControl, session);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int requestMenuItems() {
        Optional<List<Action>> availableActions = menuControl.getAvailableActionsBySession(session);
        if (availableActions.isEmpty() || availableActions.get().isEmpty()) {
            return 1;
        } else {
            this.menuItems = availableActions.get().stream()
                    .distinct()
                    .map(MenuView::createMenuItem)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        return 0;
    }

    private void printMenu() {
        int i = 0;
        System.out.println("-----------------------------------------------");
        System.out.println("***Меню****");
        for (MenuItemAbstract menuItem : menuItems) {
            System.out.println(++i + " " + menuItem.getAction().getTitle());
        }
        System.out.print("Введите номер пункта: ");
    }

    private boolean checkChosenMenuItem(int chosenMenuItem) {
        if (chosenMenuItem < 1 || chosenMenuItem > menuItems.size()) {
            System.out.println("Введен неверный номер");
            return false;
        }
        return true;
    }

    private static Optional<MenuItemAbstract> createMenuItem(Action action) {
        if (action.getAction().equals(EXIT.name())) {
            return Optional.of(new MenuItemExit(action));
        }
        if (action.getAction().equals(TESTS_QUESTS.name())) {
            return Optional.of(new MenuItemTestsQuests(action));
        }
        if (action.getAction().equals(TESTS_RESULTS.name())) {
            return Optional.of(new MenuItemTestsResults(action));
        }
        if (action.getAction().equals(USERS.name())) {
            return Optional.of(new MenuItemUsers(action));
        }
        return Optional.empty();
    }

    private boolean checkResultRequestMenuItems(int resultCode) {
        return !(resultCode > 0);
    }
}
