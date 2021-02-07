package pe.edu.unmsm.ebs.infrastructure.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pe.edu.unmsm.ebs.domain.Application;
import pe.edu.unmsm.ebs.infrastructure.entity.ApplicationEntity;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring", uses = {ApplicationTypeMapper.class, UserMapper.class}, imports = {LocalDate.class})
public interface ApplicationMapper {

    @Mappings({
            @Mapping(target = "applicationTypeName", source = "applicationTypeEntity.name"),
            @Mapping(target = "userNames", source = "userEntity.names"),
            @Mapping(target = "userSurnames", source = "userEntity.surnames"),
            @Mapping(target = "userDni", source = "userEntity.dni")
    })
    Application toApplication(ApplicationEntity applicationEntity);

    List<Application> toApplications(List<ApplicationEntity> applicationEntities);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "applicationTypeEntity", ignore = true),
            @Mapping(target = "userEntity", ignore = true)
    })
    ApplicationEntity toApplicationEntity(Application application);

}
