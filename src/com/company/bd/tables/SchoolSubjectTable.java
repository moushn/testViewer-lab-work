package com.company.bd.tables;

import com.company.bd.model.entities.SchoolSubject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SchoolSubjectTable {
    private static final List<SchoolSubject> schoolSubjectTable = new ArrayList<>(Arrays.asList(
            new SchoolSubject(1, "Русский"),
            new SchoolSubject(2, "Литература"),
            new SchoolSubject(3, "Математика"),
            new SchoolSubject(4, "Геометрия")
    ));

    public static Optional<List<SchoolSubject>> getSchoolSubjectListBySchoolSubjectIdList(List<Integer> schoolSubjectIds) {
        return Optional.ofNullable(schoolSubjectTable.stream()
                .filter(s -> schoolSubjectIds.contains(s.getSchoolSubjectId()))
                .collect(Collectors.toList())
        );
    }
}
