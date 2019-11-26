package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.ApplicationState;

import java.util.List;

public interface ApplicationStateService {
    ApplicationState getApplicationStateById(Integer id);
    void saveApplicationState(ApplicationState applicationState);
    void updateApplicationState(ApplicationState applicationState);
    void deleteApplicationState(Integer id);
    List<ApplicationState> findAll();
}
