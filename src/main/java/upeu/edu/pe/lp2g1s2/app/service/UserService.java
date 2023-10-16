package upeu.edu.pe.lp2g1s2.app.service;

import upeu.edu.pe.lp2g1s2.app.repository.ProductRepository;
import upeu.edu.pe.lp2g1s2.app.repository.UserRepository;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

public class UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public UserService(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.saveUser(userEntity);
    }

    public Iterable<UserEntity> getUsers() {
        return userRepository.getUsers();
    }

    public UserEntity getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteUserById(id);
    }

    public ProductEntity saveProduct(ProductEntity product) {
        return productRepository.saveProduct(product);
    }
}
