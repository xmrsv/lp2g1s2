package upeu.edu.pe.lp2g1s2.infrastructure.entity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import upeu.edu.pe.lp2g1s2.app.repository.ProductRepository;
import upeu.edu.pe.lp2g1s2.app.repository.StockRepository;
import upeu.edu.pe.lp2g1s2.app.repository.UserRepository;
import upeu.edu.pe.lp2g1s2.app.service.ProductService;
import upeu.edu.pe.lp2g1s2.app.service.UserService;
import upeu.edu.pe.lp2g1s2.app.service.StockService;
import upeu.edu.pe.lp2g1s2.app.service.UploadFile;

/**
 * Configuración de beans para la aplicación.
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository, UploadFile uploadFile) {
        return new ProductService(productRepository, uploadFile);
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public StockService stockService(StockRepository stockRepository) {
        return new StockService(stockRepository);
    }

    @Bean
    public UploadFile uploadFile() {
        return new UploadFile();
    }
}
