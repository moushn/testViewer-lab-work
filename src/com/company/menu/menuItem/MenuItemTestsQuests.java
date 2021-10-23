package com.company.menu.menuItem;

import com.company.authentificator.Session;
import com.company.bd.model.TestEdPresent;
import com.company.bd.model.entities.Action;
import com.company.menu.interfaces.MenuControlInt;

import java.util.List;
import java.util.Optional;

public class MenuItemTestsQuests extends MenuItemAbstract {
    public MenuItemTestsQuests(Action action) {
        super(action);
    }

    @Override
    public boolean execute(MenuControlInt menuControl, Session session) {
        Optional<List<TestEdPresent>> tests = menuControl.getTestEdPresentList(session);
        if (tests.isEmpty() || tests.get().isEmpty()) {
            System.out.println("Тесты отсутствуют или у вас нет прав на их просмотр");
            return false;
        }
        printTestList(tests.get());
        return false;
    }

    private void printTestList(List<TestEdPresent> TestEdPresents) {
        for (TestEdPresent test : TestEdPresents) {
            System.out.println("-----------------------------------------------");
            System.out.println("Тест: " + test.getTestEd().getName());
            System.out.println("Предмет: " + test.getSchoolSubject().getName());
            System.out.println("Количество вопросов: " + test.getTestEd().getQuestionsCount());
            System.out.println("-----------------------------------------------");
        }
    }
}
