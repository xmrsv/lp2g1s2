package upeu.edu.pe.lp2g1s2.infrastructure.entity.adapter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.StockEntity;

import java.util.List;

public interface StockCrudRepository extends CrudRepository<StockEntity, Integer> {

    List<StockEntity> getStockByProductEntity(ProductEntity productEntity);
}
