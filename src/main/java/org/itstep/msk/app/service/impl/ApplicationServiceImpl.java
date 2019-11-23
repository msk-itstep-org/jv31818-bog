package org.itstep.msk.app.service.impl;

import org.itstep.msk.app.entity.Application;
import org.itstep.msk.app.repository.ApplicationRepository;
import org.itstep.msk.app.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository repository;

    @Override
    public Application getApplicationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void saveApplication(Application application) {
        repository.saveAndFlush(application);
    }

    @Override
    public void updateApplication(Application application) {
        Application current = repository.getOne(application.getId());
        current.setType(application.getType());
        current.setState(application.getState());
        current.setPriority(application.getPriority());
        repository.saveAndFlush(current);
    }

    @Override
    public void deleteApplication(Long id) {
        repository.deleteById(id);
        repository.flush();
    }

    @Override
    public List<Application> findAll() {
        return repository.findAll();
    }
}
