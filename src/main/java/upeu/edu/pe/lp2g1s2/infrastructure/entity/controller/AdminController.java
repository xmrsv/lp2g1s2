package upeu.edu.pe.lp2g1s2.infrastructure.entity.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.lp2g1s2.app.service.ProductService;
import upeu.edu.pe.lp2g1s2.app.service.UserService;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2g1s2.infrastructure.entity.UserEntity;

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

    @GetMapping("/users/create")
    public String createUser() {
        return "admin/users/create";
    }

    @PostMapping("/users/save-user")
    public String saveUser(UserEntity userEntity) {
        if (userEntity.getDateCreated() == null) {
            userEntity.setDateCreated(LocalDateTime.now());
        }
        userEntity.setDateUpdated(LocalDateTime.now());
        userService.saveUser(userEntity);
        return "redirect:/admin/users/show";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {
        UserEntity userEntity = userService.getUserById(id);
        model.addAttribute("user", userEntity);
        return "admin/users/edit";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        UserEntity user = userService.getUserById(id);
        List<ProductEntity> products = (List<ProductEntity>) productService.getProductsByUser(user);

        for (ProductEntity product : products) {
            productService.deleteProductById(product.getId());
        }

        userService.deleteUserById(id);

        return "redirect:/admin/users/show";
    }
}
