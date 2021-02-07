package pe.edu.unmsm.ebs.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.unmsm.ebs.infrastructure.entity.ApplicationTypeEntity;

import java.util.Optional;

public interface SDCrudApplicationTypeRepository extends CrudRepository<ApplicationTypeEntity, Long> {

    Optional<ApplicationTypeEntity> findByName(String name);

}
