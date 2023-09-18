package upeu.edu.pe.lp2g1s2.infrastructure.entity.adapter;

import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

// Esta interfaz define un repositorio CRUD para la entidad ProductEntity
public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {

    // Este método busca productos relacionados con un UserEntity específico
    Iterable<ProductEntity> findByUserEntity(UserEntity user);
}
