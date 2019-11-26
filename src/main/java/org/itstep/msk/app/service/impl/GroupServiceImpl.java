package org.itstep.msk.app.service.impl;

import org.itstep.msk.app.entity.Group;
import org.itstep.msk.app.repository.GroupRepository;
import org.itstep.msk.app.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository repository;

    @Override
    public Group getGroupById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void saveGroup(Group group) {
        repository.saveAndFlush(group);
    }

    @Override
    public void updateGroup(Group group) {
        Group current = repository.getOne(group.getId());
        current.setGroup(group.getGroup());
        current.setUsers(group.getUsers());
        repository.saveAndFlush(current);
    }

    @Override
    public void deleteGroup(Long id) {
        repository.deleteById(id);
        repository.flush();
    }

    @Override
    public List<Group> findAll() {
        return repository.findAll();
    }
}
