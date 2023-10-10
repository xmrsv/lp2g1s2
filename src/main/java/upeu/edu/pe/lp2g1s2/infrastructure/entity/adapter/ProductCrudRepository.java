package upeu.edu.pe.lp2g1s2.infrastructure.entity.adapter;

import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer>{
    Iterable<ProductEntity> findByUserEntity(UserEntity user);
}