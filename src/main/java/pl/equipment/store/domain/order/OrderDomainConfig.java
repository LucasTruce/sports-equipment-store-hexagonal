package pl.equipment.store.domain.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.order.port.in.OrderCommandRepository;
import pl.equipment.store.domain.order.port.in.OrderQueryRepository;

@Configuration
class OrderDomainConfig {

    @Bean
    OrderCommandFacade orderCommandFacade(OrderCommandRepository orderCommandRepository){
        return new OrderCommandFacade(orderCommandRepository);
    }

    @Bean
    OrderQueryFacade orderQueryFacade(OrderQueryRepository orderQueryRepository){
        return new OrderQueryFacade(orderQueryRepository);
    }
}
