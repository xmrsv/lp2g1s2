package upeu.edu.pe.lp2g1s2.app.repository;

import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

/**
 * Interfaz que define las operaciones disponibles para gestionar productos en
 * la base de datos.
 */
public interface ProductRepository {

    /**
     * Obtiene todos los productos.
     *
     * @return Una lista de productos.
     */
    Iterable<ProductEntity> getProducts();

    /**
     * Obtiene los productos asociados a un usuario específico.
     *
     * @param user El usuario cuyos productos se desean obtener.
     * @return Una lista de productos del usuario.
     */
    Iterable<ProductEntity> getProductsByUser(UserEntity user);

    /**
     * Obtiene un producto por su ID.
     *
     * @param id El ID del producto a buscar.
     * @return El producto encontrado.
     */
    ProductEntity getProductById(Integer id);

    /**
     * Guarda un producto en la base de datos.
     *
     * @param product El producto a guardar.
     * @return El producto guardado.
     */
    ProductEntity saveProduct(ProductEntity product);

    /**
     * Elimina un producto por su ID.
     *
     * @param id El ID del producto a eliminar.
     */
    void deleteProductById(Integer id);
}
