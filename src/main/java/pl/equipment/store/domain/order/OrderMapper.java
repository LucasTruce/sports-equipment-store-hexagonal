package pl.equipment.store.domain.order;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.order.dto.OrderDto;

class OrderMapper {
    private static final IOrderMapper orderMapper = Mappers.getMapper(IOrderMapper.class);

    static OrderDto toOrderDto(Order order){
        return orderMapper.toOrderDto(order);
    }

    @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface IOrderMapper{
        OrderDto toOrderDto(Order order);
    }
}
