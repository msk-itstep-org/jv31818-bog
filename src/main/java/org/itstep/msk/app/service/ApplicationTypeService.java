package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.ApplicationType;

import java.util.List;

public interface ApplicationTypeService {
    ApplicationType getApplicationTypeById(Integer id);
    void saveApplicationType(ApplicationType applicationType);
    void updateApplicationType(ApplicationType applicationType);
    void deleteApplicationType(Integer id);
    List<ApplicationType> findAll();
}
