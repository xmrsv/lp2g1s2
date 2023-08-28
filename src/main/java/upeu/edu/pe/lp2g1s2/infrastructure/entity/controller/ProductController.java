package upeu.edu.pe.lp2g1s2.infrastructure.entity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.lp2g1s2.app.service.ProductService;

@Controller
@RequestMapping("admin/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

}
