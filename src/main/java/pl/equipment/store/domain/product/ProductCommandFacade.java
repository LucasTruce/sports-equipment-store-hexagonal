package pl.equipment.store.domain.product;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.product.dto.ProductDto;
import pl.equipment.store.domain.product.port.in.ProductCommandRepository;
import pl.equipment.store.domain.product.port.out.ProductCommand;


@RequiredArgsConstructor
class ProductCommandFacade implements ProductCommand {

    private final ProductCommandRepository productCommandRepository;


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

}
