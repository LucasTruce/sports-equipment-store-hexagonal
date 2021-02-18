package pl.equipment.store.infrastructure.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.product.dto.ProductDto;
import pl.equipment.store.domain.product.port.in.ProductCommandRepository;
import pl.equipment.store.domain.product.port.in.ProductQueryRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ProductAdapter implements ProductCommandRepository, ProductQueryRepository {
    private final ProductSpringRepository productSpringRepository;

    @Override
    public ProductDto save(ProductDto productDto) {
        ProductEntity productEntity =
                productSpringRepository.save(ProductEntity.EntityFactory.toProductEntity(productDto));
        return ProductEntity.EntityFactory.toProductDto(productEntity);
    }

    @Override
    public List<ProductDto> findProducts() {
        return productSpringRepository.findAll()
                .stream()
                .map(ProductEntity.EntityFactory::toProductDto)
                .collect(Collectors.toList());
    }
}
