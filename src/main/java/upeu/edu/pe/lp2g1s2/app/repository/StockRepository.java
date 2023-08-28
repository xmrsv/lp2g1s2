package upeu.edu.pe.lp2g1s2.app.repository;

import java.util.List;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.StockEntity;

public interface StockRepository {

    StockEntity saveStock(StockEntity stockEntity);
    List<StockEntity> getStockByProductEntity(ProductEntity productEntity);
}
