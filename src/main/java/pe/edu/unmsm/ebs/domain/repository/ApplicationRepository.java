package pe.edu.unmsm.ebs.domain.repository;

import pe.edu.unmsm.ebs.domain.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository {

    Application save(Application application);

    Optional<Application> findById(long id);

    List<Application> findAll();

    List<Application> findByUserId(long userId);

    List<Application> findByStatus(String status);

}
