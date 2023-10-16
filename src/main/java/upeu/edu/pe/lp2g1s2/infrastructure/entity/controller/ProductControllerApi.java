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
@RequestMapping("/admin/v1/products")
public class ProductControllerApi {

    private final ProductService productService;

    public ProductControllerApi(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save-product")
    public void saveProduct(
            @ModelAttribute ProductEntity product,
            @RequestParam("img") MultipartFile multipartFile, Integer userId) throws IOException {
        productService.saveProduct(product, multipartFile, userId);
    }

    @GetMapping("/show")
    public Iterable<ProductEntity> showProduct() {
        UserEntity user = new UserEntity();
        user.setId(1);
        return productService.getProductsByUser(user);
    }

    @GetMapping("/show/{id}")
    public ProductEntity show(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

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

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
        // return "redirect:/admin/products/show";
    }
}
