package upeu.edu.pe.lp2g1s2.infrastructure.entity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.lp2g1s2.app.service.ProductService;
import upeu.edu.pe.lp2g1s2.app.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;
    private final UserService userService;

    public AdminController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping
    public String home() {
        return "admin/home_admin";
    }

    @GetMapping("/users/show")
    public String users(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "admin/users/show";
    }

}
