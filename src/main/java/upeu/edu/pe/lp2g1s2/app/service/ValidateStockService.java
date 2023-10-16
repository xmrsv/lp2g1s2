package upeu.edu.pe.lp2g1s2.app.service;

import java.util.List;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.StockEntity;

public class ValidateStockService {

    private final StockService stockService;

    public ValidateStockService(StockService stockService) {
        this.stockService = stockService;
    }

    private boolean existBalance(ProductEntity product) {
        List<StockEntity> stockList = stockService.getStockByProduct(product);
        return !stockList.isEmpty();
    }

    public StockEntity calculateBalance(StockEntity stock) {
        Integer balance = 0;
        if (existBalance(stock.getProductEntity())) {
            List<StockEntity> stockList = stockService.getStockByProduct(stock.getProductEntity());
            balance = stockList.get(stockList.size() - 1).getBalance();
        }

        if (stock.getEntries() != 0) {
            balance += stock.getEntries();
        } else {
            balance -= stock.getExits();
        }

        stock.setBalance(balance);
        return stock;
    }

}
