package pl.equipment.store.domain.product.port.out;

import pl.equipment.store.domain.product.dto.CreateProductDto;
import pl.equipment.store.domain.product.dto.ProductResponseDto;

public interface ProductCommand {
    ProductResponseDto createProduct(CreateProductDto createProductDto);
}
