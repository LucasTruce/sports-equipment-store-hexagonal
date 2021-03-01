package pl.equipment.store.infrastructure.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.infrastructure.order.OrderEntity;
import pl.equipment.store.infrastructure.product.ProductEntity;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;


    private static final IEntityMapper entityMapper = Mappers.getMapper(IEntityMapper.class);

    static OrderDetailsResponseDto toOrderDetailsResponseDto(OrderDetailsEntity orderDetailsEntity) {
        return entityMapper.toOrderDetailsResponseDto(orderDetailsEntity);
    }

    static OrderDetailsEntity toOrderDetailsEntity(OrderDetailsResponseDto orderDetailsResponseDto) {
        return entityMapper.toOrderDetailsEntity(orderDetailsResponseDto);
    }

    @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface IEntityMapper {
        @Mapping(source = "orderEntity.id", target = "orderId")
        @Mapping(source = "productEntity.id", target = "productId")
        OrderDetailsResponseDto toOrderDetailsResponseDto(OrderDetailsEntity orderDetailsEntity);

        @Mapping(target = "orderEntity", ignore = true)
        @Mapping(target = "productEntity", ignore = true)
        OrderDetailsEntity toOrderDetailsEntity(OrderDetailsResponseDto orderDetailsResponseDto);

    }

}
