package pl.equipment.store.domain.orderDetails;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsRepository;
import pl.equipment.store.domain.product.port.in.ProductRepository;

@Configuration
class OrderDetailsDomainConfig {

    @Bean
    OrderDetailsCommandFacade orderDetailsCommandFacade(OrderDetailsRepository repository,
                                                        ProductRepository productRepository){
        return new OrderDetailsCommandFacade(repository, productRepository);
    }

    @Bean
    OrderDetailsQueryFacade orderDetailsQueryFacade(OrderDetailsRepository repository){
        return new OrderDetailsQueryFacade(repository);
    }

}
