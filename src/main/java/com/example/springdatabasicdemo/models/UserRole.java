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
    private Set<Users> users = new HashSet<>();

    public UserRole(Role role) {
        this.role = role;
    }

    public UserRole() {}
    public UserRole(Role role, Set<Users> users) {
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
    public Set<Users> getUsers() {
        return users;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }
}
