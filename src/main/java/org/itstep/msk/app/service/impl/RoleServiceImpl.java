package org.itstep.msk.app.service.impl;

import org.itstep.msk.app.entity.Role;
import org.itstep.msk.app.repository.RoleRepository;
import org.itstep.msk.app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public Role getRoleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void saveRole(Role role) {
        repository.saveAndFlush(role);
    }

    @Override
    public void updateRole(Role role) {
        Role current = repository.getOne(role.getId());
        current.setRole(role.getRole());
        repository.saveAndFlush(current);
    }

    @Override
    public void deleteRole(Long id) {
        repository.deleteById(id);
        repository.flush();
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }
}
