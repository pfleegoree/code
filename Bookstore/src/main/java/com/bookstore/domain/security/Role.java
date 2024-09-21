package com.bookstore.domain.security;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {
    @Id
    private String roleId;
    private String name;


    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}