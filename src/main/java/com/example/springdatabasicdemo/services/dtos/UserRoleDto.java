package com.example.springdatabasicdemo.services.dtos;

import com.example.springdatabasicdemo.constants.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.UUID;

public  class UserRoleDto {
    private  UUID id;
    private  Role role;

    public UserRoleDto(
            UUID id,
            Role role
    ) {
        this.id = id;
        this.role = role;
    }

    public UserRoleDto(Role role) {
        this.role = role;
    }

    public UserRoleDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    @NotNull
    @NotEmpty
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UUID id() {
        return id;
    }

    public Role role() {
        return role;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (UserRoleDto) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }

    @Override
    public String toString() {
        return "UserRoleDto[" +
                "id=" + id + ", " +
                "role=" + role + ']';
    }

}
