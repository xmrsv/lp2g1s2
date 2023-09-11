package upeu.edu.pe.lp2g1s2.app.service;

import java.util.List;
import upeu.edu.pe.lp2g1s2.app.repository.StockRepository;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.StockEntity;

public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public StockEntity saveStock(StockEntity stockEntity) {
        return stockRepository.saveStock(stockEntity);
    }

    public List<StockEntity> getStockByProductEntity(
            ProductEntity productEntity) {
        return stockRepository.getStockByProductEntity(productEntity);
    }
}
