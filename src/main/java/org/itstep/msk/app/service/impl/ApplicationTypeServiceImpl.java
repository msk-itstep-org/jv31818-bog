package org.itstep.msk.app.service.impl;

import org.itstep.msk.app.entity.ApplicationType;
import org.itstep.msk.app.repository.ApplicationTypeRepository;
import org.itstep.msk.app.service.ApplicationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationTypeServiceImpl implements ApplicationTypeService {

    @Autowired
    private ApplicationTypeRepository repository;

    @Override
    public ApplicationType getApplicationTypeById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void saveApplicationType(ApplicationType applicationType) {
        repository.saveAndFlush(applicationType);
    }

    @Override
    public void updateApplicationType(ApplicationType applicationType) {
        ApplicationType current = repository.getOne(applicationType.getId());
        current.setType(applicationType.getType());
        repository.saveAndFlush(current);
    }

    @Override
    public void deleteApplicationType(Integer id) {
        repository.deleteById(id);
        repository.flush();
    }

    @Override
    public List<ApplicationType> findAll() {
        return repository.findAll();
    }
}
