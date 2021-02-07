package pe.edu.unmsm.ebs.application.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.ebs.domain.Application;
import pe.edu.unmsm.ebs.domain.service.ApplicationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<List<Application>> getAll() {
        List<Application> applications = applicationService.getAll();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Application>> getByUserId(@PathVariable long userId) {
        List<Application> applications = applicationService.getByUserId(userId);
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @GetMapping("/{status}")
    public ResponseEntity<List<Application>> getByStatus(@PathVariable String status) {
        List<Application> applications = applicationService.getByStatus(status);
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Application> update(@PathVariable long id, @RequestBody Application application) {
        Application applicationUpdated = applicationService.update(id, application);
        return new ResponseEntity<>(applicationUpdated, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Application> create(@RequestBody Application application) {
        Application applicationCreated = applicationService.create(application);
        return new ResponseEntity<>(applicationCreated, HttpStatus.CREATED);
    }


}
