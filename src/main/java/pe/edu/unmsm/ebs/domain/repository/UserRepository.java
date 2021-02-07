package pe.edu.unmsm.ebs.domain.repository;

import pe.edu.unmsm.ebs.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    User save(User user);

    List<User> findAll();

}
