package pl.equipment.store.infrastructure.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.product.dto.ProductResponseDto;
import pl.equipment.store.domain.product.dto.SaveProductDto;
import pl.equipment.store.domain.product.port.in.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class ProductAdapter implements ProductRepository {
    private final ProductSpringRepository productSpringRepository;

    @Override
    public ProductResponseDto save(SaveProductDto saveProductDto) {
        ProductEntity productEntity = productSpringRepository.save(ProductEntity.toProductEntity(saveProductDto));
        return ProductEntity.toProductResponseDto(productEntity);
    }

    @Override
    public List<ProductResponseDto> findProducts() {
        return productSpringRepository.findAll()
                .stream()
                .map(ProductEntity::toProductResponseDto)
                .collect(Collectors.toList());
    }

}
