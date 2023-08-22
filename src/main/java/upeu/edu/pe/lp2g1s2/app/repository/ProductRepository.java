package upeu.edu.pe.lp2g1s2.app.repository;

import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

public interface ProductRepository {

    // Trae todos los productos
    Iterable<ProductEntity> getProducts();

    // Trae todos los productos de un usuario
    Iterable<ProductEntity> getProductsByUser(UserEntity user);

    // Trae un solo producto
    ProductEntity getProuctById(Integer id);

    // Registra un producto
    ProductEntity saveProduct(ProductEntity product);

    // Eliminar producto
    void deleteProductById(Integer id);
}
