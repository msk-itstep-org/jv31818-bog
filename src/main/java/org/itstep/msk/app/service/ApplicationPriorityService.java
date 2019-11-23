package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.ApplicationPriority;

import java.util.List;

public interface ApplicationPriorityService {
    ApplicationPriority getApplicationPriorityById(Integer id);
    void saveApplicationPriority(ApplicationPriority applicationPriority);
    void updateApplicationPriority(ApplicationPriority applicationPriority);
    void deleteApplicationPriority(Integer id);
    List<ApplicationPriority> findAll();
}
