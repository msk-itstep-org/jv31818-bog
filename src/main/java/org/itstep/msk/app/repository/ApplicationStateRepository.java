package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.ApplicationState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationStateRepository extends JpaRepository<ApplicationState, Integer> {
}
