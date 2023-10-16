package upeu.edu.pe.lp2g1s2.app.service;

import java.io.IOException;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.lp2g1s2.app.repository.ProductRepository;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

public class ProductService {

    private final ProductRepository productRepository;
    private final UserService userService;
    private final UploadFile uploadFile;
    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository, UploadFile uploadFile, UserService userService) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
        this.userService = userService;
    }

    public Iterable<ProductEntity> getProducts() {
        return productRepository.getProducts();
    }

    public Iterable<ProductEntity> getProductsByUser(UserEntity user) {
        return productRepository.getProductsByUser(user);
    }

    public ProductEntity getProductById(Integer id) {
        return productRepository.getProductById(id);
    }

    public ProductEntity saveProduct(ProductEntity product, MultipartFile multipartFile, Integer userId) throws IOException {
        // Busca el UserEntity por ID
        UserEntity user = userService.getUserById(userId);

        // Si el usuario no existe, lanza una excepción
        if (user == null) {
            throw new IllegalArgumentException("El usuario con ID " + userId + " no existe.");
        }

        // Establece el UserEntity en el producto
        product.setUserEntity(user);

        if (product.getId() == null) {
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setImage(uploadFile.upload(multipartFile));
            return productRepository.saveProduct(product);
        } else {
            ProductEntity productDB = productRepository.getProductById(product.getId());

            // Si el producto no existe, lanza una excepción
            if (productDB == null) {
                throw new IllegalArgumentException("El producto con ID " + product.getId() + " no existe.");
            }

            if (multipartFile.isEmpty()) {
                product.setImage(productDB.getImage());
            } else {
                if (!productDB.getImage().equals("default.jpg")) {
                    uploadFile.delete(productDB.getImage());
                }
                product.setImage(uploadFile.upload(multipartFile));
            }

            log.info("product: {}", productDB);

            product.setCode(productDB.getCode());
            product.setUserEntity(productDB.getUserEntity());
            product.setDateCreated(productDB.getDateCreated());
            product.setDateUpdated(LocalDateTime.now());
            return productRepository.saveProduct(product);
        }
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteProductById(id);
    }
}
