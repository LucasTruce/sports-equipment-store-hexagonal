package pl.equipment.store.domain.product;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.product.dto.CreateProductDto;
import pl.equipment.store.domain.product.dto.ProductResponseDto;
import pl.equipment.store.domain.product.port.in.ProductRepository;
import pl.equipment.store.domain.product.port.out.ProductCommand;


@RequiredArgsConstructor
class ProductCommandFacade implements ProductCommand {

    private final ProductRepository productRepository;

    @Override
    public ProductResponseDto createProduct(CreateProductDto createProductDto) {
        return productRepository.save(Product.create(createProductDto));
    }

}
