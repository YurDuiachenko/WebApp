package com.example.springdatabasicdemo.dtos.brand;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class BrandDto {
    private UUID id;
    private  String name;
    private  Date created;
    private  Date modified;

    public BrandDto(
            UUID id,
            String name,
            Date created,
            Date modified
    ) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    public BrandDto(String name, Date created, Date modified) {
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    public BrandDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Name must be minimum two characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public UUID id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Date created() {
        return created;
    }

    public Date modified() {
        return modified;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BrandDto) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.created, that.created) &&
                Objects.equals(this.modified, that.modified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created, modified);
    }

    @Override
    public String toString() {
        return "BrandDto[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "created=" + created + ", " +
                "modified=" + modified + ']';
    }

}
