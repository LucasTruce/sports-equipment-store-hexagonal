package pl.equipment.store.domain.product.port.in;

import pl.equipment.store.domain.product.dto.ProductResponseDto;
import pl.equipment.store.domain.product.dto.SaveProductDto;

import java.util.List;

public interface ProductRepository {
    ProductResponseDto save(SaveProductDto saveProductDto);

    List<ProductResponseDto> findProducts();
}
