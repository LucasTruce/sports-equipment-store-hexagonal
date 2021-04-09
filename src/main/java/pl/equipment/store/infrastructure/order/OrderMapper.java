package pl.equipment.store.infrastructure.order;

import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.dto.SaveOrderDto;
import pl.equipment.store.infrastructure.user.UserEntity;

class OrderMapper {
    static OrderEntity toEntity(SaveOrderDto saveOrderDto) {
        return new OrderEntity(saveOrderDto.getId(),
                saveOrderDto.getStatus(),
                saveOrderDto.getTotalPrice(),
                new UserEntity(
                        saveOrderDto.getUserId(),
                        null,
                        null,
                        null,
                        false,
                        false,
                        false,
                        false,
                        null
                )
        );
    }

    static ResponseOrderDto toResponseOrderDto(OrderEntity orderEntity) {
        return new ResponseOrderDto(orderEntity.getId(), orderEntity.getStatus(), orderEntity.getTotalPrice());
    }
}
