package pe.edu.unmsm.ebs.infrastructure.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.edu.unmsm.ebs.domain.Role;
import pe.edu.unmsm.ebs.domain.repository.RoleRepository;
import pe.edu.unmsm.ebs.infrastructure.entity.RoleEntity;
import pe.edu.unmsm.ebs.infrastructure.mapper.RoleMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CrudRoleRepository implements RoleRepository {

    private final SDCrudRoleRepository repository;
    private final RoleMapper mapper;

    @Override
    public Optional<Role> findByName(String name) {
        Optional<RoleEntity> roleEntityOptional = repository.findByName(name);
        return roleEntityOptional.map(mapper::toRole);
    }

}
