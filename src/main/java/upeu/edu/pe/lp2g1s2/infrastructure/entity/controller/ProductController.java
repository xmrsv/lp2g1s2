package upeu.edu.pe.lp2g1s2.infrastructure.entity.controller;

import java.io.IOException;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.lp2g1s2.app.service.ProductService;
import upeu.edu.pe.lp2g1s2.app.service.UserService;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

@Controller
@RequestMapping("admin/products")
public class ProductController {

    private final ProductService productService;
    private final UserService userService;
    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String create() {
        return "admin/products/create";
    }

    @PostMapping("/save-product")
    public String saveProduct(ProductEntity product,
            @RequestParam("userId") Integer userId,
            @RequestParam("img") MultipartFile multipartFile) throws IOException {
        // Busca el UserEntity por ID
        UserEntity user = userService.getUserById(userId);

        // Si el usuario no existe, redirige a una página de error
        if (user == null) {
            return "redirect:/error";
        }

        // Establece el UserEntity en el producto
        product.setUserEntity(user);

        // Valida los datos del producto
        if (!isValidProduct(product)) {
            return "redirect:/error";
        }

        log.info("Nombre de producto: {}", product);
        productService.saveProduct(product, multipartFile, userId);

        return "redirect:/admin";
    }

    private boolean isValidProduct(ProductEntity product) {
        return product.getName() != null && !product.getName().isEmpty()
                && product.getDescription() != null && !product.getDescription().isEmpty()
                && product.getPrice() != null && product.getPrice().compareTo(BigDecimal.ZERO) > 0;
    }

    @GetMapping("/show")
    public String showProduct(Model model) {
        //log.info("id user desde la variable de session: {}");
        UserEntity user = new UserEntity();
        user.setId(1);
        Iterable<ProductEntity> products = productService.getProductsByUser(user);
        model.addAttribute("products", products);
        return "admin/products/show";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        ProductEntity product = productService.getProductById(id);
        log.info("Product obtenido: {}", product);
        model.addAttribute("product", product);
        return "admin/products/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
        return "redirect:/admin";
    }
}
