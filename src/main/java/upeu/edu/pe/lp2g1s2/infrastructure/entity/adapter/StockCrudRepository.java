package upeu.edu.pe.lp2g1s2.infrastructure.entity.adapter;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.StockEntity;

public interface StockCrudRepository extends CrudRepository<StockEntity, Integer> {

    List<StockEntity> getStockByProduct(ProductEntity productEntity);

}
