package pl.equipment.store.infrastructure.order;

import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.order.dto.OrderDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_order")
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private LocalDateTime date;

    static class EntityFactory {
        private static final IEntityMapper entityMapper = Mappers.getMapper(IEntityMapper.class);

        static OrderEntity toOrderEntity(OrderDto orderDto){
            return entityMapper.toOrderEntity(orderDto);
        }

        static OrderDto toOrderDto(OrderEntity orderEntity){
            return entityMapper.toOrderDto(orderEntity);
        }

        @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
        interface IEntityMapper {
            OrderDto toOrderDto(OrderEntity orderEntity);
            OrderEntity toOrderEntity(OrderDto orderDto);
        }
    }
}
