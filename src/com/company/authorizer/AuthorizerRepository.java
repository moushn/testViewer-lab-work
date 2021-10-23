package com.company.authorizer;

import com.company.authentificator.Session;
import com.company.authorizer.interfaces.AuthorizerRepositoryInt;
import com.company.bd.model.entities.Action;
import com.company.bd.model.entities.Method;
import com.company.bd.tables.*;

import java.util.List;
import java.util.Optional;

public class AuthorizerRepository implements AuthorizerRepositoryInt {
    @Override
    public Optional<List<Action>> getAvailableActionsBySession(Session session) {
        Optional<List<Integer>> actionsId;
        Optional<List<Integer>> roleIds = UserRoleRelationTable.getRoleIdListByUserId(session.getUserId());
        if (roleIds.isEmpty() || roleIds.get().isEmpty()) {
            actionsId = ActionRoleRelationTable.getPublicActionsId();
            if (actionsId.isEmpty() || actionsId.get().isEmpty()) {
                return Optional.of(List.of());
            }
            return ActionTable.getActionsByActionId(actionsId.orElse(List.of()));
        }
        actionsId = ActionRoleRelationTable.getActionsIdByRoleIdList(roleIds.get());
        if (actionsId.isEmpty() || actionsId.get().isEmpty()) {
            return Optional.of(List.of());
        }
        return ActionTable.getActionsByActionId(actionsId.orElse(List.of()));
    }

    @Override
    public boolean checkAvailabilityMethodBySession(Session session, String requestedMethodName) {
        Optional<List<Integer>> roleIds = UserRoleRelationTable.getRoleIdListByUserId(session.getUserId());
        if (roleIds.isEmpty() || roleIds.get().isEmpty()) {
            return false;
        }
        Optional<List<Integer>> availableMethodIds = MethodRoleRelationTable.getMethodIdListByRoleId(roleIds.get());
        if (availableMethodIds.isEmpty() || availableMethodIds.get().isEmpty()) {
            return false;
        }
        Optional<Method> requestedMethod = MethodTable.getMethodByName(requestedMethodName);
        if (requestedMethod.isEmpty()) {
            return false;
        }
        return availableMethodIds.get().contains(requestedMethod.get().getMethodId());
    }
}
