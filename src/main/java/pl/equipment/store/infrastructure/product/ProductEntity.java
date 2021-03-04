package pl.equipment.store.infrastructure.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.product.dto.ProductResponseDto;
import pl.equipment.store.domain.product.dto.SaveProductDto;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal unitPrice;
    private int unitsInStock;
    private String imageUrl;
    private boolean active;

    private static final EntityMapper entityMapper = Mappers.getMapper(EntityMapper.class);

    static ProductEntity toProductEntity(SaveProductDto saveProductDto) {
        return entityMapper.toProductEntity(saveProductDto);
    }

    static ProductResponseDto toProductResponseDto(ProductEntity productEntity) {
        return entityMapper.toProductResponseDto(productEntity);
    }

    @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface EntityMapper {
        ProductResponseDto toProductResponseDto(ProductEntity productEntity);

        ProductEntity toProductEntity(SaveProductDto saveProductDto);
    }

}
