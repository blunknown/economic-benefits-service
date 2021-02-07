package pe.edu.unmsm.ebs.domain.repository;

import pe.edu.unmsm.ebs.domain.ApplicationType;

import java.util.List;
import java.util.Optional;

public interface ApplicationTypeRepository {

    Optional<ApplicationType> findByName(String name);

    List<ApplicationType> findAll();

}
