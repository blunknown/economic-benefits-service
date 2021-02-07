package pe.edu.unmsm.ebs.infrastructure.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.edu.unmsm.ebs.domain.User;
import pe.edu.unmsm.ebs.domain.repository.UserRepository;
import pe.edu.unmsm.ebs.infrastructure.entity.UserEntity;
import pe.edu.unmsm.ebs.infrastructure.mapper.UserMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CrudUserRepository implements UserRepository {

    private final SDCrudUserRepository repository;
    private final UserMapper mapper;

    @Override
    public Optional<User> findByUsername(String username) {
        Optional<UserEntity> userEntityOptional = repository.findByUsername(username);
        return userEntityOptional.map(mapper::toUser);
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = mapper.toUserEntity(user);
        UserEntity userEntitySaved = repository.save(userEntity);
        return mapper.toUser(userEntitySaved);
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = (List<UserEntity>) repository.findAll();
        return mapper.toUsers(userEntities);
    }

}
