package pe.edu.unmsm.ebs.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.unmsm.ebs.infrastructure.entity.ApplicationEntity;

import java.util.List;

public interface SDCrudApplicationRepository extends CrudRepository<ApplicationEntity, Long> {

    List<ApplicationEntity> findByUserId(Long userId);

    List<ApplicationEntity> findByStatus(String status);

}
