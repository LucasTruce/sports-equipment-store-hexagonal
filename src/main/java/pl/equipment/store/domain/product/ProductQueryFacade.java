package pl.equipment.store.domain.product;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.product.dto.ProductResponseDto;
import pl.equipment.store.domain.product.port.in.ProductQueryRepository;
import pl.equipment.store.domain.product.port.out.ProductQuery;

import java.util.List;

@RequiredArgsConstructor
class ProductQueryFacade implements ProductQuery {

    private final ProductQueryRepository productQueryRepository;

    @Override
    public List<ProductResponseDto> getProducts() {
        return productQueryRepository.findProducts();
    }
}
