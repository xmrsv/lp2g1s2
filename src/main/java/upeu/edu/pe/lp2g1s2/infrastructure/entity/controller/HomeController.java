package upeu.edu.pe.lp2g1s2.infrastructure.entity.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.lp2g1s2.app.service.ProductService;
import upeu.edu.pe.lp2g1s2.app.service.StockService;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.StockEntity;

@Controller
@RequestMapping("/")
public class HomeController {

    private final ProductService productService;
    private final StockService stockService;

    public HomeController(ProductService productService, StockService stockService) {
        this.productService = productService;
        this.stockService = stockService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("products",
                productService.getProducts());
        return "home";
    }

    @GetMapping("/product-detail/{id}")
    public String productDetail(@PathVariable Integer id, Model model) {
        List<StockEntity> stocks = stockService.getStockByProduct(productService.getProductById(id));
        //log.info("Id product: {}", id);
        //log.info("stock size: {}", stocks.size());
        Integer lastBalance = 0;
        if (!stocks.isEmpty()) {
            lastBalance = stocks.get(stocks.size() - 1).getBalance();
        }

        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("stock", lastBalance);
        try {
            model.addAttribute("id", 1);
        } catch (Exception e) {
            // Errorsito
        }
        return "user/product-detail";
    }
}
