package pe.edu.unmsm.ebs.infrastructure.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import pe.edu.unmsm.ebs.domain.ApplicationType;
import pe.edu.unmsm.ebs.infrastructure.entity.ApplicationTypeEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationTypeMapper {

    ApplicationType toApplicationType(ApplicationTypeEntity applicationTypeEntity);

    List<ApplicationType> toApplicationTypes(List<ApplicationTypeEntity> applicationTypeEntities);

    @InheritInverseConfiguration
    ApplicationTypeEntity toApplicationTypeEntity(ApplicationType applicationType);

}
