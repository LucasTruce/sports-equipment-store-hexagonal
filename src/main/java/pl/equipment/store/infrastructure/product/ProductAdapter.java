package pl.equipment.store.infrastructure.product;

import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsProductDto;
import pl.equipment.store.domain.orderDetails.port.in.ProductDatabase;
import pl.equipment.store.domain.product.dto.ProductResponseDto;
import pl.equipment.store.domain.product.dto.SaveProductDto;
import pl.equipment.store.domain.product.port.in.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class ProductAdapter implements ProductRepository, ProductDatabase {
    private final ProductSpringRepository productSpringRepository;

    @Override
    public ProductResponseDto save(SaveProductDto saveProductDto) {
        ProductEntity productEntity = productSpringRepository.save(ProductMapper.toEntity(saveProductDto));
        return ProductMapper.toResponseDto(productEntity);
    }

    @Override
    public List<ProductResponseDto> findProducts() {
        return productSpringRepository.findAll()
                .stream()
                .map(ProductMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Option<OrderDetailsProductDto> getPriceAndUnitsInStock(Long productId) {
        return Option.ofOptional(
                productSpringRepository
                        .findById(productId)
                        .map(ProductMapper::toProductDto));
    }

    @Override
    public Option<Long> updateUnitsInStock(Long id, int unitsInStock) {
        Optional<ProductEntity> productEntity = productSpringRepository.findById(id);
        productEntity.ifPresent(product -> product.setUnitsInStock(unitsInStock));
        return Option.ofOptional(productEntity.map(ProductEntity::getId));
    }

}
