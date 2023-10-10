package upeu.edu.pe.lp2g1s2.infrastructure.entity.adapter;

import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

public interface UserCrudRepository extends CrudRepository<UserEntity, Integer> {

}
