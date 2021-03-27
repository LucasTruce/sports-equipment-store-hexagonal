package pl.equipment.store.domain.product;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.product.dto.CreateProductDto;
import pl.equipment.store.domain.product.dto.ProductResponseDto;
import pl.equipment.store.domain.product.port.out.CreateProduct;
import pl.equipment.store.domain.product.port.out.FindProduct;

import java.util.List;

@RequiredArgsConstructor
class ProductFacade implements CreateProduct, FindProduct {

    private final ProductService productService;

    @Override
    public ProductResponseDto create(CreateProductDto createProductDto) {
        return productService.save(createProductDto);
    }

    @Override
    public List<ProductResponseDto> findAll() {
        return productService.findAll();
    }

}
