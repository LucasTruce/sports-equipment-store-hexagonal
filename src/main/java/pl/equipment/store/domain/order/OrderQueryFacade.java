package pl.equipment.store.domain.order;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.port.in.OrderRepository;
import pl.equipment.store.domain.order.port.out.OrderQuery;

import java.util.List;

@RequiredArgsConstructor
class OrderQueryFacade implements OrderQuery {

    private final OrderRepository queryRepository;

    @Override
    public List<ResponseOrderDto> findAllOrders() {
        return queryRepository.findAllOrders();
    }

    @Override
    public ResponseOrderDto findOrderById(Long id) {
        return queryRepository.findOrderById(id);
    }
}
