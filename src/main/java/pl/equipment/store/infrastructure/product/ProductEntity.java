package pl.equipment.store.infrastructure.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.product.dto.ProductDto;

import javax.persistence.*;

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

    @Column(name = "name")
    private String name;

    static class EntityFactory {
        private static final EntityMapper entityMapper = Mappers.getMapper(EntityMapper.class);

        static ProductEntity toProductEntity(ProductDto productDto){
            return entityMapper.toProductEntity(productDto);
        }

        static ProductDto toProductDto(ProductEntity productEntity){
            return entityMapper.toProductDto(productEntity);
        }

        @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
        interface EntityMapper {
            ProductDto toProductDto(ProductEntity productEntity);
            ProductEntity toProductEntity(ProductDto productDto);
        }
    }
}
