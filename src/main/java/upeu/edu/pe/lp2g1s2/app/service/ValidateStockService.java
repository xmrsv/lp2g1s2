package upeu.edu.pe.lp2g1s2.app.service;

import java.util.List;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.StockEntity;

public class ValidateStockService {

    private final StockService stockService;

    public ValidateStockService(StockService stockService) {
        this.stockService = stockService;
    }

    private boolean existBalance(ProductEntity productEntity) {
        List<StockEntity> stockList = stockService
                .getStockByProduct(productEntity);
        return !stockList.isEmpty();
    }

}
