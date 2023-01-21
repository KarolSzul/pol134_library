package org.example.library.dao;

import org.example.library.api.UserRole;
import org.example.library.model.Role;
import org.example.library.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

public class RoleDao implements RoleProvider {

    private static final String GET_ROLE_QUERY = "from Role r where r.name =:name";

    public Optional<Role> getRole(UserRole userRole) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Role> query = session.createQuery(GET_ROLE_QUERY, Role.class)
                .setParameter("name", userRole.getName());
        Optional<Role> role = query.getResultList().stream().findFirst();
        session.close();
        return role;
    }
}
