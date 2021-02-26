package pl.equipment.store.infrastructure.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.product.dto.ProductResponseDto;
import pl.equipment.store.domain.product.port.in.ProductCommandRepository;
import pl.equipment.store.domain.product.port.in.ProductQueryRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class ProductAdapter implements ProductCommandRepository, ProductQueryRepository {
    private final ProductSpringRepository productSpringRepository;

    @Override
    public ProductResponseDto save(ProductResponseDto productResponseDto) {
        ProductEntity productEntity =
                productSpringRepository.save(ProductEntity.EntityFactory.toProductEntity(productResponseDto));
        return ProductEntity.EntityFactory.toProductDto(productEntity);
    }

    @Override
    public List<ProductResponseDto> findProducts() {
        return productSpringRepository.findAll()
                .stream()
                .map(ProductEntity.EntityFactory::toProductDto)
                .collect(Collectors.toList());
    }
}
