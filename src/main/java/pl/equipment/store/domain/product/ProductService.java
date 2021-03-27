package pl.equipment.store.domain.product;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.product.dto.CreateProductDto;
import pl.equipment.store.domain.product.dto.ProductResponseDto;
import pl.equipment.store.domain.product.port.in.ProductRepository;

import java.util.List;

@RequiredArgsConstructor
class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDto save(CreateProductDto createProductDto) {
        return productRepository.save(Product.create(createProductDto));
    }

    public List<ProductResponseDto> findAll() {
        return productRepository.findProducts();
    }
}
