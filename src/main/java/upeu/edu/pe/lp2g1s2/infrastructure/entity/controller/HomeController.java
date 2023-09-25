package upeu.edu.pe.lp2g1s2.infrastructure.entity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.lp2g1s2.app.service.ProductService;

@Controller
@RequestMapping("/home") // Puede ser "/" y vacio para usar la ruta raíz
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
}
