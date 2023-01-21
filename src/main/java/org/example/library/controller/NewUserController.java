package org.example.library.controller;

import lombok.AllArgsConstructor;
import org.example.library.api.NewUserData;
import org.example.library.api.UserRole;
import org.example.library.dao.RoleDao;
import org.example.library.dao.RoleProvider;
import org.example.library.dao.UserDao;
import org.example.library.dao.UserLoader;
import org.example.library.model.Address;
import org.example.library.model.User;
import org.example.library.view.MainMenuView;
import org.example.library.view.View;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class NewUserController {

    private final RoleProvider roleProvider;
    private final UserLoader userLoader;

    public NewUserController() {
        this.roleProvider = new RoleDao();
        this.userLoader = new UserDao();
    }

    public View addNewUser(NewUserData newUserData) {
        userLoader.addNewUser(mapToUser(newUserData));
        return new MainMenuView();
    }

    public User mapToUser(NewUserData newUserData) {
        return new User(
                null,
                newUserData.getLogin(),
                newUserData.getPassword(),
                newUserData.getName(),
                newUserData.getEmail(),
                roleProvider.getRole(UserRole.USER).stream().collect(Collectors.toSet()),
                mapToAddress(newUserData),
                Set.of()
        );
    }

    public Address mapToAddress(NewUserData newUserData) {
        return new Address(
                null,
                newUserData.getPostalCode(),
                newUserData.getCity(),
                newUserData.getStreet(),
                newUserData.getApartmentNo(),
                newUserData.getBuildingNo());
    }
}
