package com.company.bd.tables;

import com.company.bd.model.entities.Method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MethodTable {
    private static final List<Method> methodTable = new ArrayList<>(Arrays.asList(
            new Method(1, "getUserList"),
            new Method(2, "getTestEdPresentList"),
            new Method(3, "getTestEdResultsPresentList")
    ));

    public static Optional<Method> getMethodByName(String name) {
        return methodTable.stream()
                .filter(m -> m.getName().equals(name))
                .findAny();
    }
}
