package upeu.edu.pe.lp2g1s2.infrastructure.entity.controller;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.lp2g1s2.app.service.ProductService;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

@RestController
@RequestMapping("/admin/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Guarda un producto junto con una imagen.
     *
     * @param productEntity El producto a guardar.
     * @param multipartFile La imagen del producto.
     * @return Una respuesta indicando el éxito de la operación.
     * @throws IOException Si ocurre un error durante la carga de la imagen.
     */
    @PostMapping("/save-product")
    public String saveProduct(
            @ModelAttribute ProductEntity productEntity,
            @RequestParam("img") MultipartFile multipartFile) throws IOException {
        return productService.saveProduct(productEntity, multipartFile).toString();
    }

    /**
     * Obtiene todos los productos de un usuario.
     *
     * @return Una lista de productos del usuario.
     */
    @GetMapping("/show")
    public Iterable<ProductEntity> showProduct() {
        UserEntity user = new UserEntity();
        user.setId(1);
        return productService.getProductsByUser(user);
    }

    /**
     * Obtiene un producto por su ID.
     *
     * @param id El ID del producto a buscar.
     * @return El producto encontrado.
     */
    @GetMapping("/show/{id}")
    public ProductEntity show(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    /**
     * Edita un producto existente por su ID.
     *
     * @param product El producto actualizado.
     * @param id El ID del producto a actualizar.
     * @return El producto actualizado.
     */
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity editProduct(
            @RequestBody ProductEntity product,
            @PathVariable Integer id) {
        ProductEntity productActual = productService.getProductById(id);
        productActual.setDescription(product.getDescription());
        productActual.setName(product.getName());
        productActual.setPrice(product.getPrice());
        productActual.setUserEntity(product.getUserEntity());
        // Lógica para actualizar el producto en la base de datos.
        // return productService.saveProduct(productActual);
        return null;
    }

    /**
     * Elimina un producto por su ID.
     *
     * @param id El ID del producto a eliminar.
     */
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }
}
