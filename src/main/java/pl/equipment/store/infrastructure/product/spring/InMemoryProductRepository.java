package pl.equipment.store.infrastructure.product.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.product.port.out.ProductRepository;
import pl.equipment.store.domain.product.port.shared.ProductDto;

@Component
class InMemoryProductRepository implements ProductRepository {
    private final ProductSpringRepository productSpringRepository;

    @Autowired
    public InMemoryProductRepository(ProductSpringRepository productSpringRepository) {
        this.productSpringRepository = productSpringRepository;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        ProductEntity productEntity =
                productSpringRepository.save(ProductEntity.EntityFactory.getInstance().toProductEntity(productDto));
        return ProductEntity.EntityFactory.getInstance().toProductDto(productEntity);
    }

    @Override
    public ProductDto load(Long productId) {
        return ProductEntity.EntityFactory
                .getInstance()
                .toProductDto(productSpringRepository.getOne(productId));
    }
}
