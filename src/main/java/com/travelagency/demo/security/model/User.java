package com.travelagency.demo.security.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany
    private Set<Role> roles;
}
