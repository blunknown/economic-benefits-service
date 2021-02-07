package pe.edu.unmsm.ebs.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.unmsm.ebs.infrastructure.entity.UserEntity;

import java.util.Optional;

public interface SDCrudUserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    Boolean existsByUsername(String username);

}
