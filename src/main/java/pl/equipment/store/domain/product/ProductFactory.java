package pl.equipment.store.domain.product;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.product.port.shared.ProductDto;

class ProductFactory {

    private static final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    static ProductDto toProductDto(Product product){
        return productMapper.toProductDto(product);
    }

    @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface ProductMapper {
        ProductDto toProductDto(Product product);
    }
}
