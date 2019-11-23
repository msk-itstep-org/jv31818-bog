package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long id);

    Optional<User> getUserByUsername(String username);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    List<User> findAll();
}
