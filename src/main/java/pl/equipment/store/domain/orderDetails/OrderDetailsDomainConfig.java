package pl.equipment.store.domain.orderDetails;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsRepository;

@Configuration
class OrderDetailsDomainConfig {

    @Bean
    OrderDetailsCommandFacade orderDetailsCommandFacade(OrderDetailsRepository repository) {
        return new OrderDetailsCommandFacade(repository);
    }

    @Bean
    OrderDetailsQueryFacade orderDetailsQueryFacade(OrderDetailsRepository repository) {
        return new OrderDetailsQueryFacade(repository);
    }

}
