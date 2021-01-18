package pl.equipment.store.infrastructure.product.spring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.product.port.shared.ProductDto;

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
        @Getter
        private static final EntityFactory instance = new EntityFactory();

        private final EntityMapper entityMapper = Mappers.getMapper(EntityMapper.class);

        ProductEntity toProductEntity(ProductDto productDto){
            return entityMapper.toProductEntity(productDto);
        }

        ProductDto toProductDto(ProductEntity productEntity){
            return entityMapper.toProductDto(productEntity);
        }

        @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
        interface EntityMapper {
            ProductDto toProductDto(ProductEntity productEntity);
            ProductEntity toProductEntity(ProductDto productDto);
        }
    }
}
