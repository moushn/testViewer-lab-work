package com.company.menu;

import com.company.bd.model.TestEdPresent;
import com.company.bd.model.TestEdResultsPresent;
import com.company.bd.model.UserRolesPresent;
import com.company.menu.interfaces.MenuRepositoryInt;
import com.company.menu.interfaces.MenuServiceInt;

import java.util.List;
import java.util.Optional;

public class MenuService implements MenuServiceInt {
    private final MenuRepositoryInt menuRepository;

    public MenuService(MenuRepositoryInt menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Optional<List<UserRolesPresent>> getUserRolesList() {
        return menuRepository.getUserRolesList();
    }

    @Override
    public Optional<List<TestEdPresent>> getTestEdPresentListByUserId(int userId) {
        return menuRepository.getTestEdPresentListByUserId(userId);
    }

    @Override
    public Optional<List<TestEdResultsPresent>> getTestEdResultsPresentListByUserId(int userId) {
        return menuRepository.getTestEdResultsPresentListByUserId(userId);
    }
}
