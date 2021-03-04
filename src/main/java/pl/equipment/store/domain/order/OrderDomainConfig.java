package pl.equipment.store.domain.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.order.port.in.OrderRepository;

@Configuration
class OrderDomainConfig {

    @Bean
    OrderCommandFacade orderCommandFacade(OrderRepository orderRepository) {
        return new OrderCommandFacade(orderRepository);
    }

    @Bean
    OrderQueryFacade orderQueryFacade(OrderRepository orderRepository) {
        return new OrderQueryFacade(orderRepository);
    }
}
