package pl.equipment.store.domain.product.port.out;

import pl.equipment.store.domain.product.dto.ProductResponseDto;

import java.util.List;

public interface FindProduct {
    List<ProductResponseDto> findAll();
}
