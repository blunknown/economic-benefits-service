package pe.edu.unmsm.ebs.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.ebs.application.security.jwt.JwtUtil;
import pe.edu.unmsm.ebs.domain.Role;
import pe.edu.unmsm.ebs.domain.User;
import pe.edu.unmsm.ebs.domain.repository.RoleRepository;
import pe.edu.unmsm.ebs.domain.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class DomainAuthService implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User signUp(User user, Set<String> strRoles) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Error: Username is already taken!");
        }
        if (strRoles.isEmpty()) {
            throw new RuntimeException("Error: Roles is empty.");
        }
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(strRole -> {
            Role role = roleRepository.findByName(strRole)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(role);
        });
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public String signIn(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtUtil.generateJwt(authentication);
    }

}
