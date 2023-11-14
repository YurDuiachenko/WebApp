package com.example.springdatabasicdemo.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    public UUID id;
    protected Date created;
    protected Date modified;

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string",
        strategy = "org.hibernate.id.UUIDGenerator")
    public UUID getId() {
        return id;
    }

    @Column(name = "created")
    public Date getCreated() {
        return created;
    }

    @Column(name = "modified")
    public Date getModified() {
        return modified;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseEntity that = (BaseEntity) o;

        if (getId() != null) {
            return getId().equals(that.getId());
        } else {
            return super.equals(o);
        }
    }

    public int hashCode() {
        return getId() != null ? getId().hashCode() : super.hashCode();
    }
}