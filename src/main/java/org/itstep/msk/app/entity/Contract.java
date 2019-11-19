package org.itstep.msk.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Long id;

    @NotNull
    @Column
    private String contract;

    public Long getId() {
        return id;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
}
