package pl.equipment.store.domain.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.product.port.in.ProductCommandRepository;
import pl.equipment.store.domain.product.port.in.ProductQueryRepository;

@Configuration
class ProductDomainConfig {

    @Bean
    ProductFacade productFacade(ProductCommandRepository productCommandRepository, ProductQueryRepository productQueryRepository){
        return new ProductFacade(productCommandRepository, productQueryRepository);
    }
}
