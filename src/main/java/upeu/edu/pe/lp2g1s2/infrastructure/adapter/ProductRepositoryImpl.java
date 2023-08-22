package upeu.edu.pe.lp2g1s2.infrastructure.adapter;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.lp2g1s2.app.repository.ProductRepository;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    
    private final ProductCrudRepository productCrudRepository;
    private final ProductEntity productEntity;
    private final UserEntity userEntity;
    
    public ProductRepositoryImpl(ProductCrudRepository productCrudRepository, ProductEntity productEntity, UserEntity userEntity) {
        this.productCrudRepository = productCrudRepository;
        this.productEntity = productEntity;
        this.userEntity = userEntity;
    }
    
    @Override
    public Iterable<ProductEntity> getProducts() {
        return productCrudRepository.findAll();
    }
    
    @Override
    public Iterable<ProductEntity> getProductsByUser(UserEntity user) {
        return productCrudRepository.findByUserEntity(userEntity);
    }
    
    @Override
    public ProductEntity getProuctById(Integer id) {
        return productCrudRepository.findById(id).get();
    }
    
    @Override
    public ProductEntity saveProduct(ProductEntity product) {
        return productCrudRepository.save(productEntity);
    }
    
    @Override
    public void deleteProductById(Integer id) {
        productCrudRepository.deleteById(id);
    }
    
}
