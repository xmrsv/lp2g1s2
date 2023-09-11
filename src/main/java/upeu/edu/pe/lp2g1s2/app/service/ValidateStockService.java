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
        List<StockEntity> stockList;
        stockList = stockService
                .getStockByProductEntity(productEntity);
        return !stockList.isEmpty();
    }

    public StockEntity calculateBalance(StockEntity stock) {
        if (stock.getEntradas() != 0) {
            if (existBalance(stock.getProductEntity())) {
                List<StockEntity> stockList = stockService.getStockByProductEntity(stock.getProductEntity());
                Integer balance = stockList.get(stockList.size() - 1).getBalance();
                stock.setBalance(balance + stock.getEntradas());
            } else {
                stock.setBalance(stock.getEntradas());
            }
        } else {
            List<StockEntity> stockList = stockService.getStockByProductEntity(stock.getProductEntity());
            Integer balance = stockList.get(stockList.size() - 1).getBalance();
            stock.setBalance(balance - stock.getSalidas());
        }

        return stock;
    }
}
