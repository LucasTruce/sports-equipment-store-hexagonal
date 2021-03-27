package pl.equipment.store.infrastructure.orderDetails;

import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.dto.SaveOrderDetailsDto;
import pl.equipment.store.infrastructure.order.OrderEntity;
import pl.equipment.store.infrastructure.product.ProductEntity;
import pl.equipment.store.infrastructure.user.UserEntity;

class OrderDetailsMapper {
    static OrderDetailsResponseDto toOrderDetailsResponseDto(OrderDetailsEntity orderDetailsEntity) {
        return new OrderDetailsResponseDto(orderDetailsEntity.getId(),
                orderDetailsEntity.getQuantity(),
                orderDetailsEntity.getOrderEntity().getId(),
                orderDetailsEntity.getProductEntity().getId());
    }

    static OrderDetailsEntity toOrderDetailsEntity(SaveOrderDetailsDto saveOrderDetailsDto) {
        return new OrderDetailsEntity(saveOrderDetailsDto.getId(),
                saveOrderDetailsDto.getQuantity(),
                new OrderEntity(saveOrderDetailsDto.getOrderId(), null, null, new UserEntity()),
                new ProductEntity(saveOrderDetailsDto.getProductId(), null, null, null, 0, null, false));
    }
}
