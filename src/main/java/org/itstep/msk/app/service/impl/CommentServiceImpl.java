package org.itstep.msk.app.service.impl;

import org.itstep.msk.app.entity.Comment;
import org.itstep.msk.app.repository.CommentRepository;
import org.itstep.msk.app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository repository;

    @Override
    public Comment getCommentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void saveComment(Comment comment) {
        repository.saveAndFlush(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        Comment current = repository.getOne(comment.getId());
        current.setComment(comment.getComment());
        repository.saveAndFlush(current);
    }

    @Override
    public void deleteComment(Long id) {
        repository.deleteById(id);
        repository.flush();
    }

    @Override
    public List<Comment> findAll() {
        return repository.findAll();
    }
}
