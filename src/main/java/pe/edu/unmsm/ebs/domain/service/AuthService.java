package pe.edu.unmsm.ebs.domain.service;

import pe.edu.unmsm.ebs.domain.User;

import java.util.Set;

public interface AuthService {

    User signUp(User user, Set<String> strRoles);

    String signIn(String username, String password);

}
