package pl.equipment.store.domain.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.order.port.in.OrderRepository;
import pl.equipment.store.domain.product.port.in.ProductRepository;

@Configuration
class OrderDomainConfig {

    @Bean
    OrderCommandFacade orderCommandFacade(OrderRepository orderRepository, ProductRepository productRepository){
        return new OrderCommandFacade(orderRepository, productRepository);
    }

    @Bean
    OrderQueryFacade orderQueryFacade(OrderRepository orderRepository){
        return new OrderQueryFacade(orderRepository);
    }
}
