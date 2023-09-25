package upeu.edu.pe.lp2g1s2.infrastructure.entity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home") // Puede ser "/" y vacio para usar la ruta raíz
public class HomeController {
    
    @GetMapping
    public String home(Model model) {
        model.addAttribute("titulo", model);
        return "home";
    }
}
