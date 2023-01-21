package org.example.library.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@ToString(exclude = {"roles", "address"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String login;
    private String password;
    private String name;
    private String email;

    @ManyToMany//(fetch=FetchType.EAGER)
    @JoinTable(
            name = "User_Role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Address address;

    @OneToMany(mappedBy = "user") //(fetch=FetchType.EAGER)
    private Set<Rental> rentals;
}
