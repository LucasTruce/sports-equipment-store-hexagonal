package pl.equipment.store.infrastructure.orderDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsRepository;
import pl.equipment.store.infrastructure.order.OrderEntity;
import pl.equipment.store.infrastructure.order.OrderSpringRepository;
import pl.equipment.store.infrastructure.product.ProductEntity;
import pl.equipment.store.infrastructure.product.ProductSpringRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class OrderDetailsAdapter implements OrderDetailsRepository {

    private final OrderDetailsSpringRepository repository;
    private final OrderSpringRepository orderRepository;
    private final ProductSpringRepository productRepository;

    @Override
    public OrderDetailsResponseDto saveOrderDetails(OrderDetailsResponseDto orderDetailsResponseDto) {

        OrderDetailsEntity orderDetailsEntity = OrderDetailsEntity.toOrderDetailsEntity(orderDetailsResponseDto);

        OrderEntity orderEntity = orderRepository.findById(orderDetailsResponseDto.getOrderId())
                .orElseThrow(() -> new EntityNotFoundException("Order not found!"));
        ProductEntity productEntity = productRepository.findById(orderDetailsResponseDto.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found!"));

        orderDetailsEntity.setOrderEntity(orderEntity);
        orderDetailsEntity.setProductEntity(productEntity);

        return OrderDetailsEntity.toOrderDetailsResponseDto(repository.save(orderDetailsEntity));
    }

    @Override
    public List<OrderDetailsResponseDto> findAllOrderDetails() {
        return repository.findAll()
                .stream()
                .map(OrderDetailsEntity::toOrderDetailsResponseDto)
                .collect(Collectors.toList());
    }
}
