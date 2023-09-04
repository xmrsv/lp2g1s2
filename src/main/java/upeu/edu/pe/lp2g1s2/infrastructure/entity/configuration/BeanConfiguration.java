package upeu.edu.pe.lp2g1s2.infrastructure.entity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import upeu.edu.pe.lp2g1s2.app.repository.ProductRepository;
import upeu.edu.pe.lp2g1s2.app.repository.StockRepository;
import upeu.edu.pe.lp2g1s2.app.service.ProductService;
import upeu.edu.pe.lp2g1s2.app.service.StockService;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }
    
    @Bean
    public StockService stockService(StockRepository stockRepository) {
        return new StockService(stockRepository);
    }
}
