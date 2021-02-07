package pe.edu.unmsm.ebs.infrastructure.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import pe.edu.unmsm.ebs.domain.Role;
import pe.edu.unmsm.ebs.infrastructure.entity.RoleEntity;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toRole(RoleEntity roleEntity);

    Set<Role> toRoles(Set<RoleEntity> roleEntities);

    @InheritInverseConfiguration
    RoleEntity toRoleEntity(Role role);

}
