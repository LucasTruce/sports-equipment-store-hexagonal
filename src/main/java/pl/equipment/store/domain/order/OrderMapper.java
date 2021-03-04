package pl.equipment.store.domain.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.order.dto.CreateOrderDto;
import pl.equipment.store.domain.order.dto.SaveOrderDto;

class OrderMapper {
    private static final IOrderMapper orderMapper = Mappers.getMapper(IOrderMapper.class);

    static Order toOrder(CreateOrderDto createOrderDto) {
        return orderMapper.toOrder(createOrderDto);
    }

    static SaveOrderDto toSaveOrderDto(Order order) {
        return orderMapper.toSaveOrderDto(order);
    }

    @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface IOrderMapper {
        SaveOrderDto toSaveOrderDto(Order order);

        @Mapping(target = "id", ignore = true)
        @Mapping(target = "totalPrice", ignore = true)
        Order toOrder(CreateOrderDto createOrderDto);
    }
}
