package upeu.edu.pe.lp2g1s2.infrastructure.entity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import upeu.edu.pe.lp2g1s2.app.service.ProductService;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

@RestController
@RequestMapping("/api/v1/products")
public class ProductControllerApi {

    private final ProductService productService;

    public ProductControllerApi(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save-product")
    public String saveProduct(@RequestBody ProductEntity productEntity) {
        // return productService.saveProduct(productEntity).toString();
        return null;
    }

    @GetMapping("/show")
    public Iterable<ProductEntity> showProduct() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        return productService.getProductsByUser(userEntity);
    }

    @GetMapping("/show/{id}")
    public ProductEntity show(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity editProductEntity(
            @RequestBody ProductEntity productEntity,
            @PathVariable Integer id) {
        ProductEntity productActual = new ProductEntity();

        productActual.setName(productEntity.getName());
        productActual.setDescription(productEntity.getDescription());
        productActual.setPrice(productEntity.getPrice());
        productActual.setImage(productEntity.getImage());
        productActual.setDateCreated(productEntity.getDateCreated());
        productActual.setDateUpdated(productEntity.getDateUpdated());

        // return productService.saveProduct(productActual);
        return null;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }
}
