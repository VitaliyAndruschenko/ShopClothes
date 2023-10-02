package com.shop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, Collection<User> users, Collection<Privilege> privileges) {
        this.name = name;
        this.users = users;
        this.privileges = privileges;
    }

    public Role() {
    }
}
