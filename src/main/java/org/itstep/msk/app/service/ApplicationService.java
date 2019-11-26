package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Application;

import java.util.List;

public interface ApplicationService {
    Application getApplicationById(Long id);
    void saveApplication(Application application);
    void updateApplication(Application application);
    void deleteApplication(Long id);
    List<Application> findAll();
}
