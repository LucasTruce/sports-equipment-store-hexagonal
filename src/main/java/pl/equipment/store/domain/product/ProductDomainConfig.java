package pl.equipment.store.domain.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.product.port.in.ProductRepository;

@Configuration
class ProductDomainConfig {

    @Bean
    ProductCommandFacade productCommandFacade(ProductRepository productRepository){
        return new ProductCommandFacade(productRepository);
    }

    @Bean
    ProductQueryFacade productQueryFacade(ProductRepository productRepository){
        return new ProductQueryFacade(productRepository);
    }
}
