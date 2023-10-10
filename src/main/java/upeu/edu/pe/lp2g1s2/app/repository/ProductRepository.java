package upeu.edu.pe.lp2g1s2.app.repository;

import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

/**
 * Interfaz que define las operaciones disponibles para gestionar productos en
 * la base de datos.
 */
public interface ProductRepository {

    // metodo que trae todos los productos
    Iterable<ProductEntity> getProducts();

    Iterable<ProductEntity> getProductsByUser(UserEntity user);

    ProductEntity getProductById(Integer id);

    ProductEntity saveProduct(ProductEntity product);

    void deleteProductById(Integer id);

}
