package upeu.edu.pe.lp2g1s2.app.service;

import java.util.List;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.StockEntity;

/**
 * Servicio para validar y actualizar el saldo de un producto en el inventario.
 */
public class ValidateStockService {

    private final StockService stockService;

    /**
     * Constructor de ValidateStockService.
     *
     * @param stockService Servicio de gestión del inventario.
     */
    public ValidateStockService(StockService stockService) {
        this.stockService = stockService;
    }

    /**
     * Verifica si existe un saldo de inventario para un producto.
     *
     * @param productEntity Entidad de producto para la cual verificar el saldo.
     * @return `true` si existe saldo, `false` si no.
     */
    private boolean existBalance(ProductEntity productEntity) {
        List<StockEntity> stockList = stockService.getStockByProductEntity(productEntity);
        return !stockList.isEmpty();
    }

    /**
     * Calcula y actualiza el saldo de un producto en el inventario.
     *
     * @param stock StockEntity que contiene información de entradas, salidas y
     * producto.
     * @return El mismo objeto StockEntity con el saldo actualizado.
     */
    public StockEntity calculateBalance(StockEntity stock) {
        if (stock.getEntries() != 0) {
            calculateBalanceForEntries(stock);
        } else {
            calculateBalanceForExits(stock);
        }
        return stock;
    }

    /**
     * Calcula el saldo en función de las entradas de producto.
     *
     * @param stock StockEntity que contiene información de entradas y producto.
     */
    private void calculateBalanceForEntries(StockEntity stock) {
        if (existBalance(stock.getProductEntity())) {
            List<StockEntity> stockList = stockService.getStockByProductEntity(stock.getProductEntity());
            Integer balance = stockList.get(stockList.size() - 1).getBalance();
            stock.setBalance(balance + stock.getEntries());
        } else {
            stock.setBalance(stock.getEntries());
        }
    }

    /**
     * Calcula el saldo en función de las salidas de producto.
     *
     * @param stock StockEntity que contiene información de salidas y producto.
     */
    private void calculateBalanceForExits(StockEntity stock) {
        List<StockEntity> stockList = stockService.getStockByProductEntity(stock.getProductEntity());
        Integer balance = stockList.get(stockList.size() - 1).getBalance();
        stock.setBalance(balance - stock.getExits());
    }
}
