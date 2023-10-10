package upeu.edu.pe.lp2g1s2.infrastructure.entity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.lp2g1s2.app.service.ProductService;

@Controller
@RequestMapping("/") // Puede ser "/" y vacio para usar la ruta raíz
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("products",
                productService.getProducts());
        return "home";
    }

    @GetMapping("/product-detail/{id}")
    public String productDetail(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "user/product_detail";
    }
}
