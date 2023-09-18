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

    /**
     * Guarda una entidad de stock en la base de datos.
     *
     * @param stockEntity Entidad de stock a guardar.
     * @return La entidad de stock guardada.
     */
    public StockEntity saveStock(StockEntity stockEntity) {
        return stockRepository.saveStock(stockEntity);
    }

    /**
     * Obtiene una lista de entidades de stock asociadas a un producto
     * específico.
     *
     * @param productEntity Entidad de producto para la cual buscar el stock.
     * @return Lista de entidades de stock asociadas al producto.
     */
    public List<StockEntity> getStockByProductEntity(ProductEntity productEntity) {
        return stockRepository.getStockByProductEntity(productEntity);
    }
}
