package pl.equipment.store.domain.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.order.port.in.OrderCommandRepository;
import pl.equipment.store.domain.order.port.in.OrderQueryRepository;

@Configuration
class OrderDomainConfig {

    @Bean
    OrderFacade orderFacade(OrderCommandRepository orderCommandRepository, OrderQueryRepository orderQueryRepository){
        return new OrderFacade(orderCommandRepository, orderQueryRepository);
    }
}
