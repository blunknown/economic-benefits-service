package pe.edu.unmsm.ebs.domain.service;

import pe.edu.unmsm.ebs.domain.User;

public interface UserService {

    User getByUsername(String username);

    User getByJwt();

}
