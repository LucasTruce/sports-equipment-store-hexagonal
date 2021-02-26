package pl.equipment.store.domain.product;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.product.dto.ProductResponseDto;

class ProductMapper {
    private static final IProductMapper productMapper = Mappers.getMapper(IProductMapper.class);

    static ProductResponseDto toProductDto(Product product){
        return productMapper.toProductDto(product);
    }

    @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface IProductMapper {
        ProductResponseDto toProductDto(Product product);
    }
}
