package org.example.library;

import org.example.library.api.UserRole;
import org.example.library.model.Role;
import org.example.library.model.User;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ApplicationContext {

    private static ActiveUser activeUser;

    public static void setActiveUser(User user) {
        activeUser = new ActiveUser(
                user.getLogin(),
                user.getName(),
                mapToUserRoles(user.getRoles())
        );
    }

    public static ActiveUser getActiveUser() {
        return activeUser;
    }

    private static Set<UserRole> mapToUserRoles(Set<Role> roles) {
        return roles.stream()
                .map(role -> UserRole.find(role.getName()))
                .collect(Collectors.toSet());
    }
}
