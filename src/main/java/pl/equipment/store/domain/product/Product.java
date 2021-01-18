package pl.equipment.store.domain.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.product.port.shared.ProductDto;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Builder
class Product {
    private int id;
    private String name;

    static class ProductFactory {
        @Getter
        private static final ProductFactory instance = new ProductFactory();

        private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

        Product createProduct(String productName){
            return new Product(0, productName);
        }

        ProductDto toProductDto(Product product){
            return productMapper.toProductDto(product);
        }

        @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
        interface ProductMapper {
            ProductDto toProductDto(Product product);
        }
    }
}
