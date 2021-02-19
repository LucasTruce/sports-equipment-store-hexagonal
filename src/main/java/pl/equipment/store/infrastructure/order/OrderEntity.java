package pl.equipment.store.infrastructure.order;

import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.order.dto.CreateOrderDto;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.infrastructure.user.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "user_order")
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    static class EntityFactory {
        private static final IEntityMapper entityMapper = Mappers.getMapper(IEntityMapper.class);

        static OrderEntity toOrderEntity(CreateOrderDto createOrderDto){
            return entityMapper.toOrderEntity(createOrderDto);
        }

        static ResponseOrderDto toResponseOrderDto(OrderEntity orderEntity){
            return entityMapper.toResponseOrderDto(orderEntity);
        }

        @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
        interface IEntityMapper {
            ResponseOrderDto toResponseOrderDto(OrderEntity orderEntity);
            @Mapping(target = "userEntity", ignore = true)
            OrderEntity toOrderEntity(CreateOrderDto createOrderDto);
        }
    }
}
