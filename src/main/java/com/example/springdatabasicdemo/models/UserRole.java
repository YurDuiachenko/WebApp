package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.constants.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {

    private Role role;
    private Set<User> users = new HashSet<>();

    public UserRole() {}
    public UserRole(Role role, Set<User> users) {
        this.role = role;
        this.users = users;
    }

    public UserRole(Role role, Date created, Date modified) {
        super.created = created;
        super.modified = modified;
        this.role = role;
    }

    @Column(name = "name")
    public Role getRole() {
        return role;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    public Set<User> getUsers() {
        return users;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
