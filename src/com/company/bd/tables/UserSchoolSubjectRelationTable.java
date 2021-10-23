package com.company.bd.tables;

import com.company.bd.model.entities.UserSchoolSubjectRelation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserSchoolSubjectRelationTable {
    private static final List<UserSchoolSubjectRelation> userSchoolSubjectRelationTable = new ArrayList<>(Arrays.asList(
            new UserSchoolSubjectRelation(2, 1),
            new UserSchoolSubjectRelation(2, 2),
            new UserSchoolSubjectRelation(3, 3),
            new UserSchoolSubjectRelation(3, 4),
            new UserSchoolSubjectRelation(4, 1),
            new UserSchoolSubjectRelation(4, 2),
            new UserSchoolSubjectRelation(5, 3),
            new UserSchoolSubjectRelation(5, 4)
    ));

    public static Optional<List<Integer>> getSchoolSubjectIdListByUserId(int userId) {
        return Optional.ofNullable(
                userSchoolSubjectRelationTable.stream()
                        .filter(ussr -> ussr.getUserId() == userId)
                        .map(UserSchoolSubjectRelation::getSchoolSubjectId)
                        .collect(Collectors.toList())
        );
    }
}
