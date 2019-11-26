package org.itstep.msk.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="application_types")
public class ApplicationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NotNull
    @Column
    private String type;

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return getType();
    }
}
