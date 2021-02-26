package pl.equipment.store.domain.orderDetails;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsCommandRepository;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsQueryRepository;

@Configuration
class OrderDetailsDomainConfig {

    @Bean
    OrderDetailsCommandFacade orderDetailsCommandFacade(OrderDetailsCommandRepository repository){
        return new OrderDetailsCommandFacade(repository);
    }

    @Bean
    OrderDetailsQueryFacade orderDetailsQueryFacade(OrderDetailsQueryRepository repository){
        return new OrderDetailsQueryFacade(repository);
    }
}
