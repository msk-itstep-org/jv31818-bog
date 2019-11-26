package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Role;

import java.util.List;

public interface RoleService {
    Role getRoleById(Long id);
    void saveRole(Role role);
    void updateRole(Role role);
    void deleteRole(Long id);
    List<Role> findAll();
}
