package pe.edu.unmsm.ebs.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.ebs.domain.ApplicationType;
import pe.edu.unmsm.ebs.domain.repository.ApplicationTypeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DomainApplicationTypeService implements ApplicationTypeService{

    private final ApplicationTypeRepository repository;

    @Override
    public List<ApplicationType> getAll() {
        return repository.findAll();
    }

}
