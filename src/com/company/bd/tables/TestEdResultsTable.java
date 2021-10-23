package com.company.bd.tables;

import com.company.bd.model.entities.TestEdResults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestEdResultsTable {
    private static final List<TestEdResults> testEdResultsTable = new ArrayList<>(Arrays.asList(
            new TestEdResults(1, 3.56),
            new TestEdResults(2, 4.48),
            new TestEdResults(3, 4.8),
            new TestEdResults(4, 3.22)
    ));

    public static Optional<List<TestEdResults>> getTestEdResultsListByTestEdIdList(List<Integer> testEdIds) {
        return Optional.ofNullable(
                testEdResultsTable.stream()
                        .filter(t -> testEdIds.contains(t.getTestEdId()))
                        .collect(Collectors.toList())
        );
    }
}
