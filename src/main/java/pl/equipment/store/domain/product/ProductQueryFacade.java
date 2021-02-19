package pl.equipment.store.domain.product;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.product.dto.ProductDto;
import pl.equipment.store.domain.product.port.in.ProductQueryRepository;
import pl.equipment.store.domain.product.port.out.ProductQuery;

import java.util.List;

@RequiredArgsConstructor
class ProductQueryFacade implements ProductQuery {

    private final ProductQueryRepository productQueryRepository;

    @Override
    public List<ProductDto> getProducts() {
        return productQueryRepository.findProducts();
    }
}
