package pl.equipment.store.domain.orderDetails;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;

class OrderDetailsMapper {
    private static final IOrderDetailsMapper orderDetailsMapper = Mappers.getMapper(IOrderDetailsMapper.class);

    static OrderDetails toOrderDetails(CreateOrderDetailsDto createOrderDetailsDto) {
        return orderDetailsMapper.toOrderDetails(createOrderDetailsDto);
    }

    @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface IOrderDetailsMapper {

        @Mapping(target = "id", ignore = true)
        OrderDetails toOrderDetails(CreateOrderDetailsDto createOrderDetailsDto);

    }
}
