package pe.edu.unmsm.ebs.domain.service;

import pe.edu.unmsm.ebs.domain.Application;

import java.util.List;

public interface ApplicationService {

    Application create(Application application);

    Application update(long id, Application application);

    List<Application> getAll();

    List<Application> getByUserId(long userId);

    List<Application> getByStatus(String status);

}
