package pe.edu.unmsm.ebs.application.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.unmsm.ebs.domain.ApplicationType;
import pe.edu.unmsm.ebs.domain.service.ApplicationTypeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/application-types")
public class ApplicationTypeController {

    private final ApplicationTypeService applicationTypeService;

    @GetMapping
    public ResponseEntity<List<ApplicationType>> getAll() {
        List<ApplicationType> requestTypes = applicationTypeService.getAll();
        return new ResponseEntity<>(requestTypes, HttpStatus.OK);
    }

}
