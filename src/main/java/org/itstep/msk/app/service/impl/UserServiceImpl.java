package org.itstep.msk.app.service.impl;

import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.repository.UserRepository;
import org.itstep.msk.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }


    @Override
    public Optional<User> getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        repository.saveAndFlush(user);
    }

    @Override
    public void updateUser(User user) {
        User current = repository.getOne(user.getId());
        current.setFirstName(user.getFirstName());
        current.setMiddleName(user.getMiddleName());
        current.setLastName(user.getLastName());
        current.setUsername(user.getUsername());
        current.setPassword(user.getPassword());
        current.setRoles(user.getRoles());
        current.setComments(user.getComments());
        repository.saveAndFlush(current);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
        repository.flush();
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
