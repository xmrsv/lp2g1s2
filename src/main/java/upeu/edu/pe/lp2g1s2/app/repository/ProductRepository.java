package upeu.edu.pe.lp2g1s2.app.repository;

import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

public interface ProductRepository {

    Iterable<ProductEntity> getProducts();

    Iterable<ProductEntity> getProductsByUser(UserEntity user);

    ProductEntity getProductById(Integer id);

    ProductEntity saveProduct(ProductEntity product);

    void deleteProductById(Integer id);

}
