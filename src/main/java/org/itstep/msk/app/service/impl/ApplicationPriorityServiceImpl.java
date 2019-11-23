package org.itstep.msk.app.service.impl;

import org.itstep.msk.app.entity.ApplicationPriority;
import org.itstep.msk.app.repository.ApplicationPriorityRepository;
import org.itstep.msk.app.service.ApplicationPriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationPriorityServiceImpl implements ApplicationPriorityService {

    @Autowired
    private ApplicationPriorityRepository repository;

    @Override
    public ApplicationPriority getApplicationPriorityById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void saveApplicationPriority(ApplicationPriority applicationPriority) {
        repository.saveAndFlush(applicationPriority);
    }

    @Override
    public void updateApplicationPriority(ApplicationPriority applicationPriority) {
        ApplicationPriority current = repository.getOne(applicationPriority.getId());
        current.setPriority(applicationPriority.getPriority());
        repository.saveAndFlush(current);
    }

    @Override
    public void deleteApplicationPriority(Integer id) {
        repository.deleteById(id);
        repository.flush();
    }

    @Override
    public List<ApplicationPriority> findAll() {
        return repository.findAll();
    }
}
