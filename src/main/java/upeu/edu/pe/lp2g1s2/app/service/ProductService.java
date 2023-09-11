package upeu.edu.pe.lp2g1s2.app.service;

import java.io.IOException;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;
import upeu.edu.pe.lp2g1s2.app.repository.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository;
    private final UploadFile uploadFile;
    private final Logger log = LoggerFactory
            .getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository,
            UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
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

    public ProductEntity saveProduct(ProductEntity product,
            MultipartFile multipartFile) throws IOException {
        if (product.getId() == null) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(1);
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setUserEntity(userEntity);
            product.setImage(uploadFile.upload(multipartFile));
            return productRepository.saveProduct(product);
        } else {
            ProductEntity productEntityDatabase = productRepository
                    .getProuctById(product.getId());
            // Logger, sirve para ver en consola el producto a editar
            log.info("product: {}", productEntityDatabase);

            // Si la imagen no se carga, usa la imagen por defecto
            if (multipartFile.isEmpty()) {
                product.setImage(productEntityDatabase.getImage());
            } else {
                // Se guardará la imagen que se envia actualmente.
                // La imagen se eliminara si no es la imagen por defecto.
                // La imagen por defecto nunca se va a eliminar.
                if (!productEntityDatabase.getImage()
                        .equals("default.jpg")) {
                    uploadFile.delete(productEntityDatabase.getImage());
                }
                product.setImage(uploadFile.upload(multipartFile));
            }
            product.setCode(productEntityDatabase.getCode());
            product.setUserEntity(productEntityDatabase.
                    getUserEntity());
            product.setDateCreated(productEntityDatabase.
                    getDateCreated());
            product.setDateUpdated(LocalDateTime.now());
            return productRepository.saveProduct(product);
        }
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteProductById(id);
    }
}
