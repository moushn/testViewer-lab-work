package com.company.menu;

import com.company.bd.model.TestEdPresent;
import com.company.bd.model.TestEdResultsPresent;
import com.company.bd.model.UserRolesPresent;
import com.company.bd.model.entities.*;
import com.company.bd.tables.*;
import com.company.menu.interfaces.MenuRepositoryInt;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MenuRepository implements MenuRepositoryInt {
    @Override
    public Optional<List<UserRolesPresent>> getUserRolesList() {
        Optional<List<Integer>> roleIds;
        Optional<List<Role>> roles;
        List<UserRolesPresent> userRolesPresents = new LinkedList<>();
        Optional<List<User>> users = UserTable.getUsers();
        if (users.isEmpty() || users.get().isEmpty()) {
            return Optional.empty();
        }
        for (User user : users.get()) {
            roleIds = UserRoleRelationTable.getRoleIdListByUserId(user.getUserId());
            if (roleIds.isEmpty() || roleIds.get().isEmpty()) {
                continue;
            }
            roles = RoleTable.getRoleListByRoleIdList(roleIds.get());
            if (roles.isEmpty() || roles.get().isEmpty()) {
                continue;
            }
            userRolesPresents.add(new UserRolesPresent(user, roles.get()));
        }
        return Optional.ofNullable(userRolesPresents);
    }

    @Override
    public Optional<List<TestEdPresent>> getTestEdPresentListByUserId(int userId) {
        Optional<SchoolSubject> schoolSubject;
        List<TestEdPresent> testEdPresents = new LinkedList<>();
        Optional<List<Integer>> schoolSubjectIds = UserSchoolSubjectRelationTable.getSchoolSubjectIdListByUserId(userId);
        if (schoolSubjectIds.isEmpty() || schoolSubjectIds.get().isEmpty()) {
            return Optional.empty();
        }
        Optional<List<SchoolSubject>> schoolSubjects = SchoolSubjectTable.getSchoolSubjectListBySchoolSubjectIdList(schoolSubjectIds.get());
        if (schoolSubjects.isEmpty() || schoolSubjects.get().isEmpty()) {
            return Optional.empty();
        }
        Optional<List<TestEd>> tests = TestEdTable.getTestEdListBySchoolSubjectIdList(schoolSubjectIds.get());
        if (tests.isEmpty() || tests.get().isEmpty()) {
            return Optional.empty();
        }
        for (TestEd test : tests.get()) {
            schoolSubject = schoolSubjects.get().stream()
                    .filter(s -> s.getSchoolSubjectId() == test.getSchoolSubjectId())
                    .findAny();
            if (schoolSubject.isEmpty()) {
                continue;
            }
            testEdPresents.add(new TestEdPresent(test, schoolSubject.get()));
        }
        return Optional.ofNullable(testEdPresents);
    }

    @Override
    public Optional<List<TestEdResultsPresent>> getTestEdResultsPresentListByUserId(int userId) {
        TestEdResults testEdResults;
        List<TestEdResultsPresent> testEdResultsPresents = new LinkedList<>();
        Optional<List<TestEdPresent>> testEdPresents = getTestEdPresentListByUserId(userId);
        if (testEdPresents.isEmpty() || testEdPresents.get().isEmpty()) {
            return Optional.empty();
        }
        List<Integer> testEdIds = testEdPresents.get().stream()
                .map(t -> t.getTestEd().getTestEdId())
                .collect(Collectors.toList());
        Optional<List<TestEdResults>> testEdResultsList = TestEdResultsTable.getTestEdResultsListByTestEdIdList(testEdIds);
        for (TestEdPresent testEdPresent : testEdPresents.get()) {
            testEdResults = testEdResultsList
                    .orElseGet(() -> List.of(new TestEdResults(testEdPresent.getTestEd().getTestEdId(), 0.0)))
                    .stream()
                    .filter(t -> t.getTestEdId() == testEdPresent.getTestEd().getTestEdId())
                    .findAny()
                    .orElseGet(() -> new TestEdResults(testEdPresent.getTestEd().getTestEdId(), 0.0));
            testEdResultsPresents.add(new TestEdResultsPresent(testEdPresent.getTestEd(), testEdPresent.getSchoolSubject(), testEdResults));
        }
        return Optional.ofNullable(testEdResultsPresents);
    }
}
