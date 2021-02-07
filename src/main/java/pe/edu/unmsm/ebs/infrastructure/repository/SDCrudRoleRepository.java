package pe.edu.unmsm.ebs.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.unmsm.ebs.infrastructure.entity.RoleEntity;

import java.util.Optional;

public interface SDCrudRoleRepository extends CrudRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(String name);

}
