package upeu.edu.pe.lp2g1s2.app.service;

import upeu.edu.pe.lp2g1s2.app.repository.UserRepository;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.saveUser(userEntity);
    }

    public Iterable<UserEntity> getUsers() {
        return userRepository.getUsers();
    }

    void deleteUserById(Integer id) {
        userRepository.deleteUserById(id);
    }
}
