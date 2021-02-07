package pe.edu.unmsm.ebs.domain.repository;

import pe.edu.unmsm.ebs.domain.Role;

import java.util.Optional;

public interface RoleRepository {

    Optional<Role> findByName(String name);

}
