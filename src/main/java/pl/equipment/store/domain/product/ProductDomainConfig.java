package pl.equipment.store.domain.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.product.port.in.ProductRepository;

@Configuration
class ProductDomainConfig {

    @Bean
    ProductFacade productCommandFacade(ProductRepository productRepository) {
        ProductService productService = new ProductService(productRepository);
        return new ProductFacade(productService);
    }

}
