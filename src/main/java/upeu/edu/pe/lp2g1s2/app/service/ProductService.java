package upeu.edu.pe.lp2g1s2.app.service;

import java.io.IOException;
import java.time.LocalDateTime;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.lp2g1s2.app.repository.ProductRepository;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

/**
 * Servicio para operaciones relacionadas con productos.
 */
public class ProductService {

    private final ProductRepository productRepository;
    private final UploadFile uploadFile;

    /**
     * Constructor del servicio.
     *
     * @param productRepository Repositorio de productos.
     * @param uploadFile Servicio de carga de archivos.
     */
    public ProductService(ProductRepository productRepository,
            UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
    }

    /**
     * Obtiene todos los productos disponibles en el sistema.
     *
     * @return Iterable de ProductEntity que representa todos los productos.
     */
    public Iterable<ProductEntity> getProducts() {
        return productRepository.getProducts();
    }

    /**
     * Obtiene los productos de un usuario específico.
     *
     * @param user Usuario para el cual buscar productos.
     * @return Iterable de ProductEntity que representa los productos del
     * usuario.
     */
    public Iterable<ProductEntity> getProductsByUser(UserEntity user) {
        return productRepository.getProductsByUser(user);
    }

    /**
     * Obtiene un producto por su ID.
     *
     * @param id ID del producto a buscar.
     * @return El Producto si se encuentra, o null si no se encuentra.
     */
    public ProductEntity getProductById(Integer id) {
        return productRepository.getProductById(id);
    }

    /**
     * Guarda o actualiza un producto en la base de datos.
     *
     * @param product Producto a guardar o actualizar.
     * @param multipartFile Archivo de imagen asociado al producto.
     * @return El Producto guardado o actualizado.
     * @throws IOException Si ocurre un error durante la carga de la imagen.
     */
    public ProductEntity saveProduct(ProductEntity product, MultipartFile multipartFile) throws IOException {
        if (product.getId() == null) {
            // Nuevo producto, configurar detalles iniciales
            UserEntity userEntity = new UserEntity();
            userEntity.setId(1);
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setUserEntity(userEntity);
            product.setImage(uploadFile.upload(multipartFile));
        } else {
            // Producto existente, actualizar detalles
            ProductEntity existingProduct = getProductById(product.getId());
            if (!multipartFile.isEmpty()) {
                // Si se proporciona una nueva imagen, cargarla
                uploadFile.delete(existingProduct.getImage());
                product.setImage(uploadFile.upload(multipartFile));
            } else {
                // Si no se proporciona una nueva imagen, conservar la imagen actual
                product.setImage(existingProduct.getImage());
            }
            product.setCode(existingProduct.getCode());
            product.setDateCreated(existingProduct.getDateCreated());
            product.setDateUpdated(LocalDateTime.now());
        }
        return productRepository.saveProduct(product);
    }

    /**
     * Elimina un producto por su ID.
     *
     * @param id ID del producto a eliminar.
     */
    public void deleteProductById(Integer id) {
        productRepository.deleteProductById(id);
    }
}
