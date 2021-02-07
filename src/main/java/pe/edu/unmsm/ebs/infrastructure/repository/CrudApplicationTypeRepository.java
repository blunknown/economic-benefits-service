package pe.edu.unmsm.ebs.infrastructure.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.edu.unmsm.ebs.domain.ApplicationType;
import pe.edu.unmsm.ebs.domain.repository.ApplicationTypeRepository;
import pe.edu.unmsm.ebs.infrastructure.entity.ApplicationTypeEntity;
import pe.edu.unmsm.ebs.infrastructure.mapper.ApplicationTypeMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CrudApplicationTypeRepository implements ApplicationTypeRepository {

    private final SDCrudApplicationTypeRepository repository;
    private final ApplicationTypeMapper mapper;

    @Override
    public Optional<ApplicationType> findByName(String name) {
        Optional<ApplicationTypeEntity> applicationTypeEntityOptional = repository.findByName(name);
        return applicationTypeEntityOptional.map(mapper::toApplicationType);
    }

    @Override
    public List<ApplicationType> findAll() {
        List<ApplicationTypeEntity> applicationTypeEntities = (List<ApplicationTypeEntity>) repository.findAll();
        return mapper.toApplicationTypes(applicationTypeEntities);
    }
}
