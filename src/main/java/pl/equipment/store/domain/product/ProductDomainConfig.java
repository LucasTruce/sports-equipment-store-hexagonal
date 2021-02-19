package pl.equipment.store.domain.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.product.port.in.ProductCommandRepository;
import pl.equipment.store.domain.product.port.in.ProductQueryRepository;

@Configuration
class ProductDomainConfig {

    @Bean
    ProductCommandFacade productCommandFacade(ProductCommandRepository productCommandRepository){
        return new ProductCommandFacade(productCommandRepository);
    }

    @Bean
    ProductQueryFacade productQueryFacade(ProductQueryRepository productQueryRepository){
        return new ProductQueryFacade(productQueryRepository);
    }
}
