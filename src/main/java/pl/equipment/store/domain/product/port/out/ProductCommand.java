package pl.equipment.store.domain.product.port.out;

import pl.equipment.store.domain.product.dto.ProductDto;

public interface ProductCommand {
    ProductDto createProduct(ProductDto productDto);
}
