package pl.equipment.store.domain.product.port.in;

import pl.equipment.store.domain.product.dto.ProductResponseDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository {
    ProductResponseDto save(ProductResponseDto productResponseDto);
    ProductResponseDto updateUnitsInStock(Long id, int unitsInStock);

    List<ProductResponseDto> findProducts();
    BigDecimal getProductPrice(Long id);
    int getUnitsInStock(Long id);
}
