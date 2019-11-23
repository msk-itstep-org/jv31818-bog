package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.ApplicationPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationPriorityRepository extends JpaRepository<ApplicationPriority, Integer> {
}
