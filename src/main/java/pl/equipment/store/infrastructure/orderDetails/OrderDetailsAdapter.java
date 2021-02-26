package pl.equipment.store.infrastructure.orderDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsCommandRepository;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsQueryRepository;
import pl.equipment.store.infrastructure.order.OrderEntity;
import pl.equipment.store.infrastructure.order.OrderSpringRepository;
import pl.equipment.store.infrastructure.product.ProductEntity;
import pl.equipment.store.infrastructure.product.ProductSpringRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class OrderDetailsAdapter implements OrderDetailsCommandRepository, OrderDetailsQueryRepository {

    private final OrderDetailsSpringRepository repository;
    private final OrderSpringRepository orderRepository;
    private final ProductSpringRepository productRepository;


    @Override
    @Transactional
    public OrderDetailsResponseDto saveOrderDetails(OrderDetailsResponseDto orderDetailsResponseDto) {
        OrderEntity orderEntity = orderRepository.findById(orderDetailsResponseDto.getOrderId())
                .orElseThrow(() -> new EntityNotFoundException("Order not found!"));
        ProductEntity productEntity = productRepository.findById(orderDetailsResponseDto.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found!"));

        orderEntity.setTotalPrice(orderEntity.getTotalPrice() + (orderDetailsResponseDto.getQuantity() * productEntity.getUnitPrice()));

        OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity(orderDetailsResponseDto.getOrderId(), orderDetailsResponseDto.getQuantity(), orderEntity, productEntity);
        return OrderDetailsEntity.EntityFactory.toOrderDetailsResponseDto(repository.save(orderDetailsEntity));
    }

    @Override
    public List<OrderDetailsResponseDto> findAllOrderDetails() {
        return repository.findAll()
                .stream()
                .map(OrderDetailsEntity.EntityFactory::toOrderDetailsResponseDto)
                .collect(Collectors.toList());
    }
}
