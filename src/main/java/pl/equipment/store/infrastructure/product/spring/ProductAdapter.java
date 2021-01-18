package pl.equipment.store.infrastructure.product.spring;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.product.port.out.ProductRepository;
import pl.equipment.store.domain.product.port.shared.ProductDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ProductAdapter implements ProductRepository{
    private final ProductSpringRepository productSpringRepository;

    @Override
    public ProductDto save(ProductDto productDto) {
        ProductEntity productEntity =
                productSpringRepository.save(ProductEntity.EntityFactory.getInstance().toProductEntity(productDto));
        return ProductEntity.EntityFactory.getInstance().toProductDto(productEntity);
    }

    @Override
    public List<ProductDto> findProducts() {
        return productSpringRepository.findAll()
                .stream()
                .map(c -> ProductEntity.EntityFactory
                        .getInstance()
                        .toProductDto(c))
                .collect(Collectors.toList());
    }
}
