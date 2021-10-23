package com.company.bd.tables;

import com.company.bd.model.entities.TestEd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestEdTable {
    private static final List<TestEd> testEdTable = new ArrayList<>(Arrays.asList(
            new TestEd(1, 1, "Тест1"),
            new TestEd(2, 2, "Тест2"),
            new TestEd(3, 3, "Тест3"),
            new TestEd(4, 4, "Тест4")
    ));

    public static Optional<List<TestEd>> getTestEdListBySchoolSubjectIdList(List<Integer> schoolSubjectIds) {
        return Optional.ofNullable(testEdTable.stream()
                .filter(t -> schoolSubjectIds.contains(t.getSchoolSubjectId()))
                .collect(Collectors.toList())
        );
    }
}
