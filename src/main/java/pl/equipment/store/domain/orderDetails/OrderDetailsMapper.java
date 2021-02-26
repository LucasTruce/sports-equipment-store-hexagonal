package pl.equipment.store.domain.orderDetails;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;

class OrderDetailsMapper {
    private static final IOrderDetailsMapper orderDetailsMapper = Mappers.getMapper(IOrderDetailsMapper.class);

    static OrderDetailsResponseDto toOrderDetailsResponseDto(OrderDetails orderDetails){
        return orderDetailsMapper.toOrderDetailsResponseDto(orderDetails);
    }


    @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface IOrderDetailsMapper{
        OrderDetailsResponseDto toOrderDetailsResponseDto(OrderDetails orderDetails);
    }
}
