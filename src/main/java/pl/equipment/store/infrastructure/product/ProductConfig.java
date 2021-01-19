package pl.equipment.store.infrastructure.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.product.ProductFacadeImpl;
import pl.equipment.store.domain.product.port.out.ProductFacade;
import pl.equipment.store.infrastructure.product.spring.ProductAdapter;
import pl.equipment.store.infrastructure.product.spring.ProductSpringRepository;

@Configuration
class ProductConfig {

    @Bean
    public ProductFacade productFacade(ProductSpringRepository productSpringRepository){

        return new ProductFacadeImpl(new ProductAdapter(productSpringRepository));
    }
}

