package upeu.edu.pe.lp2g1s2.infrastructure.entity.adapter;


import org.springframework.stereotype.Repository;

import upeu.edu.pe.lp2g1s2.app.repository.UserRepository;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private final UserCrudRepository userCrudRepository;

    public UserRepositoryImpl(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }
      
    @Override
    public Iterable<UserEntity> getUsers() {
        //metodo propio de Spring 
        return userCrudRepository.findAll();
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
       return userCrudRepository.save(userEntity);
    }

    @Override
    public void deleteUserById(Integer id) {
       userCrudRepository.deleteById(id);
    }
    
}