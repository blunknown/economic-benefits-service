package pe.edu.unmsm.ebs.application.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.unmsm.ebs.application.web.request.Credentials;
import pe.edu.unmsm.ebs.application.web.request.UserRequest;
import pe.edu.unmsm.ebs.application.web.response.JwtResponse;
import pe.edu.unmsm.ebs.application.web.response.UserResponse;
import pe.edu.unmsm.ebs.domain.Role;
import pe.edu.unmsm.ebs.domain.User;
import pe.edu.unmsm.ebs.domain.service.AuthService;

import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/sign-in")
    public ResponseEntity<JwtResponse> signIn(@RequestBody Credentials request) {
        String jwt = authService.signIn(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserResponse> signUp(@RequestBody UserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setNames(request.getNames());
        user.setSurnames(request.getSurnames());
        user.setDni(request.getDni());
        user.setMobileNumber(request.getMobileNumber());
        User newUser = authService.signUp(user, request.getRoles());
        return new ResponseEntity<>(new UserResponse(newUser.getId(), newUser.getUsername(),
                newUser.getPassword(), newUser.getNames(), newUser.getSurnames(),
                newUser.getDni(), newUser.getMobileNumber(),
                newUser.getRoles().stream().map(Role::getName).collect(Collectors.toSet())),
                HttpStatus.CREATED);
    }

}
