package upeu.edu.pe.lp2g1s2.app.service;

import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;
import upeu.edu.pe.lp2g1s2.app.repository.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<ProductEntity> getProducts() {
        return productRepository.getProducts();
    }

    public Iterable<ProductEntity> getProductsByUser(UserEntity user) {
        return productRepository.getProductsByUser(user);
    }

    public ProductEntity getProductById(Integer id) {
        return productRepository.getProuctById(id);
    }

    public ProductEntity saveProduct(ProductEntity product) {
        return productRepository.saveProduct(product);
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteProductById(id);
    }
}
