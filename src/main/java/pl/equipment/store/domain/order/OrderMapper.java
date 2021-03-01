package pl.equipment.store.domain.order;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;

class OrderMapper {
    private static final IOrderMapper orderMapper = Mappers.getMapper(IOrderMapper.class);

    static ResponseOrderDto toResponseOrderDto(Order order){
        return orderMapper.toResponseOrderDto(order);
    }
    static Order toOrder(ResponseOrderDto responseOrderDto) {
        return orderMapper.toOrder(responseOrderDto);
    }

    @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface IOrderMapper{
        ResponseOrderDto toResponseOrderDto(Order order);
        Order toOrder(ResponseOrderDto responseOrderDto);
    }
}
