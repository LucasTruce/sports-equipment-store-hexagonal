package pl.equipment.store.infrastructure.orderDetails;

import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsProductDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.dto.SaveOrderDetailsDto;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsRepository;
import pl.equipment.store.infrastructure.order.OrderEntity;
import pl.equipment.store.infrastructure.order.OrderSpringRepository;
import pl.equipment.store.infrastructure.product.ProductSpringRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class OrderDetailsAdapter implements OrderDetailsRepository {

    private final OrderDetailsSpringRepository repository;
    private final OrderSpringRepository orderRepository;
    private final ProductSpringRepository productRepository;

    @Override
    @Transactional
    public OrderDetailsResponseDto save(SaveOrderDetailsDto saveOrderDetailsDto) {

        orderRepository.findById(saveOrderDetailsDto.getOrderId())
                .ifPresent(o -> o.setTotalPrice(saveOrderDetailsDto.getTotalPrice()));
        productRepository.findById(saveOrderDetailsDto.getProductId())
                .ifPresent(p -> p.setUnitsInStock(saveOrderDetailsDto.getUnitsInStock()));

        OrderDetailsEntity entity = repository.save(OrderDetailsEntity.toOrderDetailsEntity(saveOrderDetailsDto));
        return OrderDetailsEntity.toOrderDetailsResponseDto(entity);
    }

    @Override
    public List<OrderDetailsResponseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(OrderDetailsEntity::toOrderDetailsResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Option<OrderDetailsProductDto> getProductPriceAndUnits(Long productId) {
        return Option.ofOptional(productRepository.findById(productId).map(OrderDetailsEntity::toOrderDetailsProductDto));
    }

    @Override
    public Option<BigDecimal> getOrderTotalPrice(Long orderId) {
        return Option.ofOptional(orderRepository.findById(orderId).map(OrderEntity::getTotalPrice));
    }

}
