package org.itstep.msk.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Long id;

    @NotNull
    @Column
    private String comment;

    @NotNull
    @ManyToOne
    @JoinColumn(name="comment_user_id", nullable = false)
    private User user;

    @NotNull
    @Column(name="create_date")
    private Calendar createDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name="application_id", nullable = false)
    private Application application;

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    @Override
    public int hashCode() {

        return getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Comment)) {
            return false;
        }
        return ((Comment) obj).getId().equals(getId());
    }

    @Override
    public String toString() {
        return getComment();
    }
}
