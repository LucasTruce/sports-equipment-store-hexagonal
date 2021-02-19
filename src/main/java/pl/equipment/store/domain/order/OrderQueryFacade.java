package pl.equipment.store.domain.order;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.port.in.OrderQueryRepository;
import pl.equipment.store.domain.order.port.out.OrderQuery;

import java.util.List;

@RequiredArgsConstructor
class OrderQueryFacade implements OrderQuery {

    private final OrderQueryRepository queryRepository;

    @Override
    public List<ResponseOrderDto> findAllOrders() {
        return queryRepository.findAllOrders();
    }
}
