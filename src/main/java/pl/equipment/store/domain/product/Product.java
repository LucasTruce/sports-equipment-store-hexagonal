package pl.equipment.store.domain.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.product.port.shared.ProductDto;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Builder
class Product {
    private int id;
    private String name;

    static class ProductFactory {
        private static final AtomicInteger SEQUENCE = new AtomicInteger();
        @Getter
        private static final ProductFactory instance = new ProductFactory();

        private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

        Product createProduct(String productName){
            return new Product(SEQUENCE.incrementAndGet(), productName);
        }

        Product toProduct(ProductDto productDto){
            return productMapper.toProduct(productDto);
        }

        ProductDto toProductDto(Product product){
            return productMapper.toProductDto(product);
        }

        @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
        interface ProductMapper {
            ProductDto toProductDto(Product product);
            Product toProduct(ProductDto productDto);
        }
    }
}
