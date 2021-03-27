package pl.equipment.store.domain.orderDetails;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.orderDetails.port.in.OrderDatabase;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsRepository;
import pl.equipment.store.domain.orderDetails.port.in.ProductDatabase;

@Configuration
class OrderDetailsDomainConfig {

    @Bean
    OrderDetailsFacade orderDetailsCommandFacade(OrderDetailsRepository repository,
                                                 ProductDatabase productRepository,
                                                 OrderDatabase orderRepository) {
        OrderDetailsService service = new OrderDetailsService(repository, productRepository, orderRepository);
        return new OrderDetailsFacade(service);
    }
}
