package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment getCommentById(Long id);
    void saveComment(Comment comment);
    void updateComment(Comment comment);
    void deleteComment(Long id);
    List<Comment> findAll();
}
