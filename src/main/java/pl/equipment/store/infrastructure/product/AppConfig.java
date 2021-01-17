package pl.equipment.store.infrastructure.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.product.ProductFacade;
import pl.equipment.store.domain.product.port.out.ProductRepository;

@Configuration
class AppConfig {

    @Bean
    ProductFacade productFacade(ProductRepository productRepository){
        return new ProductFacade(productRepository);
    }
}

