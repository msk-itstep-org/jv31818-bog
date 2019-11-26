package org.itstep.msk.app.service.impl;

import org.itstep.msk.app.entity.ApplicationState;
import org.itstep.msk.app.repository.ApplicationStateRepository;
import org.itstep.msk.app.service.ApplicationStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationStateServiceImpl implements ApplicationStateService {

    @Autowired
    private ApplicationStateRepository repository;

    @Override
    public ApplicationState getApplicationStateById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void saveApplicationState(ApplicationState applicationState) {
        repository.saveAndFlush(applicationState);
    }

    @Override
    public void updateApplicationState(ApplicationState applicationState) {
        ApplicationState current = repository.getOne(applicationState.getId());
        current.setState(applicationState.getState());
        repository.saveAndFlush(current);
    }

    @Override
    public void deleteApplicationState(Integer id) {
        repository.deleteById(id);
        repository.flush();
    }

    @Override
    public List<ApplicationState> findAll() {
        return repository.findAll();
    }
}
