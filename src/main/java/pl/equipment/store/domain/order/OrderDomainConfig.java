package pl.equipment.store.domain.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.order.port.in.OrderRepository;
import pl.equipment.store.domain.order.port.in.UserDatabase;

@Configuration
class OrderDomainConfig {

    @Bean
    OrderFacade orderFacade(OrderRepository orderRepository, UserDatabase userDatabase) {
        OrderService orderService = new OrderService(orderRepository, userDatabase);
        return new OrderFacade(orderService);
    }

}
