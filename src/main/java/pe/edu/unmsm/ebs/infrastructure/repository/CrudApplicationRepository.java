package pe.edu.unmsm.ebs.infrastructure.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.edu.unmsm.ebs.domain.Application;
import pe.edu.unmsm.ebs.domain.repository.ApplicationRepository;
import pe.edu.unmsm.ebs.infrastructure.entity.ApplicationEntity;
import pe.edu.unmsm.ebs.infrastructure.mapper.ApplicationMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CrudApplicationRepository implements ApplicationRepository {

    private final SDCrudApplicationRepository repository;
    private final ApplicationMapper mapper;

    @Override
    public Application save(Application application) {
        ApplicationEntity applicationEntity = mapper.toApplicationEntity(application);
        ApplicationEntity applicationEntitySaved = repository.save(applicationEntity);
        return mapper.toApplication(applicationEntitySaved);
    }

    @Override
    public Optional<Application> findById(long id) {
        Optional<ApplicationEntity> applicationEntityOptional = repository.findById(id);
        return applicationEntityOptional.map(mapper::toApplication);
    }

    @Override
    public List<Application> findAll() {
        List<ApplicationEntity> applicationEntities = (List<ApplicationEntity>) repository.findAll();
        return mapper.toApplications(applicationEntities);
    }

    @Override
    public List<Application> findByUserId(long userId) {
        List<ApplicationEntity> applicationEntities = repository.findByUserId(userId);
        return mapper.toApplications(applicationEntities);
    }

    @Override
    public List<Application> findByStatus(String status) {
        List<ApplicationEntity> applicationEntities = repository.findByStatus(status);
        return mapper.toApplications(applicationEntities);
    }

}
