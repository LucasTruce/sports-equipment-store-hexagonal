package pl.equipment.store.domain.order;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.order.dto.CreateOrderDto;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.dto.UpdateOrderDto;
import pl.equipment.store.domain.order.port.in.OrderRepository;
import pl.equipment.store.domain.order.port.out.OrderCommand;
import pl.equipment.store.domain.product.port.in.ProductRepository;

import java.math.BigDecimal;

@RequiredArgsConstructor
class OrderCommandFacade implements OrderCommand {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public ResponseOrderDto createOrder(CreateOrderDto createOrderDto) {
        Order order = Order.create(createOrderDto.getStatus(), createOrderDto.getUserId());
        return orderRepository.saveOrder(OrderMapper.toResponseOrderDto(order));
    }

    @Override
    public ResponseOrderDto updateOrder(ResponseOrderDto responseOrderDto, UpdateOrderDto updateOrderDto) {
        BigDecimal productPrice = productRepository.getProductPrice(updateOrderDto.getProductId());
        Order order = OrderMapper.toOrder(responseOrderDto);
        order.setTotalPrice(order.getTotalPrice() + updateOrderDto.getQuantity() * productPrice.doubleValue());
        return orderRepository.saveOrder(OrderMapper.toResponseOrderDto(order));
    }
}
