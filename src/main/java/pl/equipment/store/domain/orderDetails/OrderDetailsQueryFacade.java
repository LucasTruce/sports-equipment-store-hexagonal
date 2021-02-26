package pl.equipment.store.domain.orderDetails;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsQueryRepository;
import pl.equipment.store.domain.orderDetails.port.out.OrderDetailsQuery;

import java.util.List;

@RequiredArgsConstructor
class OrderDetailsQueryFacade implements OrderDetailsQuery {

    private final OrderDetailsQueryRepository repository;

    @Override
    public List<OrderDetailsResponseDto> findAllOrderDetails() {
        return repository.findAllOrderDetails();
    }
}
