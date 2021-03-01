package pl.equipment.store.infrastructure.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.product.dto.ProductResponseDto;
import pl.equipment.store.domain.product.port.in.ProductRepository;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class ProductAdapter implements ProductRepository {
    private final ProductSpringRepository productSpringRepository;

    @Override
    public ProductResponseDto save(ProductResponseDto productResponseDto) {
        ProductEntity productEntity =
                productSpringRepository.save(ProductEntity.toProductEntity(productResponseDto));
        return ProductEntity.toProductDto(productEntity);
    }

    @Override
    public ProductResponseDto updateUnitsInStock(Long id, int unitsInStock) {
        ProductEntity productEntity = productSpringRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found!"));
        productEntity.setUnitsInStock(unitsInStock);
        return ProductEntity.toProductDto(productSpringRepository.save(productEntity));
    }


    @Override
    public List<ProductResponseDto> findProducts() {
        return productSpringRepository.findAll()
                .stream()
                .map(ProductEntity::toProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal getProductPrice(Long id) {
        ProductEntity productEntity = productSpringRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found!"));
        return productEntity.getUnitPrice();
    }

    @Override
    public int getUnitsInStock(Long id) {
        ProductEntity productEntity = productSpringRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found!"));
        return productEntity.getUnitsInStock();
    }
}
