package pe.edu.unmsm.ebs.application.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.ebs.application.web.response.UserResponse;
import pe.edu.unmsm.ebs.domain.Role;
import pe.edu.unmsm.ebs.domain.User;
import pe.edu.unmsm.ebs.domain.service.UserService;

import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> getByUsername(@PathVariable String username) {
        User user = userService.getByUsername(username);
        return ResponseEntity.ok(new UserResponse(user.getId(), user.getUsername(),
                user.getPassword(), user.getNames(), user.getSurnames(),
                user.getDni(), user.getMobileNumber(),
                user.getRoles().stream().map(Role::getName).collect(Collectors.toSet())));
    }

    @GetMapping("/jwt")
    public ResponseEntity<UserResponse> getByJwt() {
        User user = userService.getByJwt();
        return ResponseEntity.ok(new UserResponse(user.getId(), user.getUsername(),
                user.getPassword(), user.getNames(), user.getSurnames(),
                user.getDni(), user.getMobileNumber(),
                user.getRoles().stream().map(Role::getName).collect(Collectors.toSet())));
    }

}
