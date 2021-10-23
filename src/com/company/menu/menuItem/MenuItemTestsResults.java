package com.company.menu.menuItem;

import com.company.authentificator.Session;
import com.company.bd.model.TestEdResultsPresent;
import com.company.bd.model.entities.Action;
import com.company.menu.interfaces.MenuControlInt;

import java.util.List;
import java.util.Optional;

public class MenuItemTestsResults extends MenuItemAbstract {
    public MenuItemTestsResults(Action action) {
        super(action);
    }

    @Override
    public boolean execute(MenuControlInt menuControl, Session session) {
        Optional<List<TestEdResultsPresent>> tests = menuControl.getTestEdResultsPresentList(session);
        if (tests.isEmpty() || tests.get().isEmpty()) {
            System.out.println("Тесты отсутствуют или у вас нет прав на их просмотр");
            return false;
        }
        printTestList(tests.get());
        return false;
    }

    private void printTestList(List<TestEdResultsPresent> testEdResultsPresents) {
        for (TestEdResultsPresent test : testEdResultsPresents) {
            System.out.println("-----------------------------------------------");
            System.out.println("Тест: " + test.getTestEd().getName());
            System.out.println("Предмет: " + test.getSchoolSubject().getName());
            System.out.println("Средний балл: " + test.getTestEdResults().getAverageScore());
            System.out.println("-----------------------------------------------");
        }
    }
}
