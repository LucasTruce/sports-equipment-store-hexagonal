package pl.equipment.store.infrastructure.order;

import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.order.dto.ResponseOrderDto;
import pl.equipment.store.domain.order.dto.SaveOrderDto;
import pl.equipment.store.infrastructure.user.UserEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "user_order")
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    private static final EntityMapper entityMapper = Mappers.getMapper(EntityMapper.class);

    static OrderEntity toOrderEntity(SaveOrderDto saveOrderDto) {
        return entityMapper.toOrderEntity(saveOrderDto);
    }

    static ResponseOrderDto toResponseOrderDto(OrderEntity orderEntity) {
        return entityMapper.toResponseOrderDto(orderEntity);
    }

    @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface EntityMapper {
        ResponseOrderDto toResponseOrderDto(OrderEntity orderEntity);

        @Mapping(source = "userId", target = "userEntity.id")
        OrderEntity toOrderEntity(SaveOrderDto saveOrderDto);

    }
}

