package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Group;

import java.util.List;

public interface GroupService {
    Group getGroupById(Long id);
    void saveGroup(Group group);
    void updateGroup(Group group);
    void deleteGroup(Long id);
    List<Group> findAll();
}
