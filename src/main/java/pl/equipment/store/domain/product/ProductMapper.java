package pl.equipment.store.domain.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.product.dto.CreateProductDto;
import pl.equipment.store.domain.product.dto.SaveProductDto;

class ProductMapper {
    private static final IProductMapper productMapper = Mappers.getMapper(IProductMapper.class);

    static Product toProduct(CreateProductDto createProductDto) {
        return productMapper.toProduct(createProductDto);
    }

    static SaveProductDto toSaveProductDto(Product product) {
        return productMapper.toSaveProductDto(product);
    }

    @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface IProductMapper {

        @Mapping(target = "id", ignore = true)
        @Mapping(target = "imageUrl", ignore = true)
        @Mapping(target = "active", ignore = true)
        Product toProduct(CreateProductDto createProductDto);

        SaveProductDto toSaveProductDto(Product product);
    }
}
