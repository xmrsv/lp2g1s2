package upeu.edu.pe.lp2g1s2.app.repository;

import java.util.List;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.StockEntity;

/**
 * Repositorio para gestionar el stock de productos.
 */
public interface StockRepository {

    /**
     * Guarda una entidad de stock en la base de datos.
     *
     * @param stockEntity Entidad de stock a guardar.
     * @return La entidad de stock guardada.
     */
    StockEntity saveStock(StockEntity stockEntity);

    /**
     * Obtiene una lista de entidades de stock asociadas a un producto
     * específico.
     *
     * @param productEntity Entidad de producto para la cual buscar el stock.
     * @return Lista de entidades de stock asociadas al producto.
     */
    List<StockEntity> getStockByProductEntity(ProductEntity productEntity);
}
