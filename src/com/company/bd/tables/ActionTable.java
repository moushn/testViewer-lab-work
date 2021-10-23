package com.company.bd.tables;

import com.company.bd.model.entities.Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ActionTable {
    private final static List<Action> actionTable = new ArrayList<>(Arrays.asList(
            new Action(1, "TESTS_QUESTS", "Просмотр тестов и вопросов"),
            new Action(2, "TESTS_RESULTS", "Просмотреть тесты и результаты"),
            new Action(3, "USERS", "Просмотреть юзеров"),
            new Action(4, "EXIT", "Выход")
    ));

    public static Optional<List<Action>> getActionsByActionId(List<Integer> list) { // мб перед вызовом гета проверять только Optional, а внутри метода сам лист на пустоту
        return Optional.ofNullable(actionTable.stream()
                .filter(a -> list.contains(a.getActionId()))
                .collect(Collectors.toList()));
    }
}
