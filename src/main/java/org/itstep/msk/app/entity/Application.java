package org.itstep.msk.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Set;

@Entity
@Table(name="applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name="type_id", referencedColumnName = "id")
    private ApplicationType type;

    @NotNull
    @Column(name="create_date")
    private Calendar createDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    private ApplicationState state;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    private ApplicationPriority priority;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;

    @OneToMany(mappedBy = "application")
    private Set<Comment> comments;

    @ManyToMany
    @JoinTable(
            name = "application_groups",
            joinColumns = {@JoinColumn(name = "application_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "id")}
    )
    private Set<Group> groups;

    public Long getId() {
        return id;
    }

    public ApplicationType getType() {
        return type;
    }

    public void setType(ApplicationType type) {
        this.type = type;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public ApplicationState getState() {
        return state;
    }

    public void setState(ApplicationState state) {
        this.state = state;
    }

    public ApplicationPriority getPriority() {
        return priority;
    }

    public void setPriority(ApplicationPriority priority) {
        this.priority = priority;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public int hashCode() {

        return getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Application)) {
            return false;
        }
        return ((Application) obj).getId().equals(getId());
    }
}
