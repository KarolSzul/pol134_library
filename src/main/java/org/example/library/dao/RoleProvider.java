package org.example.library.dao;

import org.example.library.api.UserRole;
import org.example.library.model.Role;

import java.util.Optional;

public interface RoleProvider {
    Optional<Role> getRole(UserRole userRole);
}
