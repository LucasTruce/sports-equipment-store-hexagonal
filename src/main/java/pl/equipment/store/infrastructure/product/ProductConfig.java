package pl.equipment.store.infrastructure.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.product.ProductFacade;
import pl.equipment.store.domain.product.port.in.ProductPort;
import pl.equipment.store.infrastructure.product.spring.ProductAdapter;
import pl.equipment.store.infrastructure.product.spring.ProductSpringRepository;

@Configuration
class ProductConfig {

    //@Bean
    //ProductRepository productRepository(ProductSpringRepository productSpringRepository){
    //    return new ProductAdapter(productSpringRepository);
    //}

    @Bean
    public ProductPort productPort(ProductSpringRepository productSpringRepository){

        return new ProductFacade(new ProductAdapter(productSpringRepository));
    }
}

