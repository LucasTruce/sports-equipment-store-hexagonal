package pl.equipment.store.domain.product;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.product.dto.ProductDto;
import pl.equipment.store.domain.product.port.in.ProductCommandRepository;
import pl.equipment.store.domain.product.port.in.ProductQueryRepository;
import pl.equipment.store.domain.product.port.out.ProductCommand;
import pl.equipment.store.domain.product.port.out.ProductQuery;

import java.util.List;


@RequiredArgsConstructor
class ProductFacade implements ProductCommand, ProductQuery {

    private final ProductCommandRepository productCommandRepository;
    private final ProductQueryRepository productQueryRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = Product.create(productDto.getName(),
                productDto.getDescription(),
                productDto.getUnitPrice(),
                productDto.getUnitsInStock(),
                productDto.getImageUrl(),
                productDto.isActive());
        return productCommandRepository.save(ProductMapper.toProductDto(product));
    }

    @Override
    public List<ProductDto> getProducts() {
        return productQueryRepository.findProducts();
    }
}
