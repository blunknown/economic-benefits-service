package pe.edu.unmsm.ebs.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.ebs.domain.Application;
import pe.edu.unmsm.ebs.domain.repository.ApplicationRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class DomainApplicationService implements ApplicationService {

    private final ApplicationRepository repository;

    @Override
    public Application create(Application application) {
        application.setStartDate(LocalDate.now());
        return repository.save(application);
    }

    @Override
    public Application update(long id, Application application) {
        Application application1 = getById(id);
        application1.setApplicationTypeId(application.getApplicationTypeId());
        application1.setUserId(application.getUserId());
        application1.setBeneficiaryNames(application.getBeneficiaryNames());
        application1.setBeneficiarySurnames(application.getBeneficiarySurnames());
        application1.setBeneficiaryDni(application.getBeneficiaryDni());
        application1.setBeneficiaryEmail(application.getBeneficiaryEmail());
        application1.setBeneficiaryMobileNumber(application.getBeneficiaryMobileNumber());
        application1.setAmount(application.getAmount());
        application1.setStartDate(application.getStartDate());
        application1.setEndDate(application.getEndDate());
        application1.setStatus(application.getStatus());
        application1.setComment(application.getComment());
        return repository.save(application1);
    }

    @Override
    public List<Application> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Application> getByUserId(long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Application> getByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Transactional
    public Application getById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with given id doesn't exist"));
    }

}
