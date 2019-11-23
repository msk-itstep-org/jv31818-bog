package org.itstep.msk.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="application_priorities")
public class ApplicationPriority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NotNull
    @Column
    private String priority;

    public Integer getId() {
        return id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return getPriority();
    }
}
