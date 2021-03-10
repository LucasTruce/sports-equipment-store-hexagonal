package pl.equipment.store.infrastructure.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsProductDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.dto.SaveOrderDetailsDto;
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


    private static final EntityMapper entityMapper = Mappers.getMapper(EntityMapper.class);

    static OrderDetailsResponseDto toOrderDetailsResponseDto(OrderDetailsEntity orderDetailsEntity) {
        return entityMapper.toOrderDetailsResponseDto(orderDetailsEntity);
    }

    static OrderDetailsEntity toOrderDetailsEntity(SaveOrderDetailsDto saveOrderDetailsDto) {
        return entityMapper.toOrderDetailsEntity(saveOrderDetailsDto);
    }

    static OrderDetailsProductDto toOrderDetailsProductDto(ProductEntity productEntity) {
        return entityMapper.toOrderDetailsProductDto(productEntity);
    }


    @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface EntityMapper {
        @Mapping(source = "orderEntity.id", target = "orderId")
        @Mapping(source = "productEntity.id", target = "productId")
        OrderDetailsResponseDto toOrderDetailsResponseDto(OrderDetailsEntity orderDetailsEntity);

        @Mapping(source = "productId", target = "productEntity.id")
        @Mapping(source = "unitsInStock", target = "productEntity.unitsInStock")
        @Mapping(source = "orderId", target = "orderEntity.id")
        @Mapping(source = "totalPrice", target = "orderEntity.totalPrice")
        OrderDetailsEntity toOrderDetailsEntity(SaveOrderDetailsDto saveOrderDetailsDto);

        OrderDetailsProductDto toOrderDetailsProductDto(ProductEntity productEntity);

    }

}
