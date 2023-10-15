package upeu.edu.pe.lp2g1s2.app.repository;

import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

public interface UserRepository {

    UserEntity saveUser(UserEntity userEntity);

    Iterable<UserEntity> getUsers();

    void deleteUserById(Integer id);
}
