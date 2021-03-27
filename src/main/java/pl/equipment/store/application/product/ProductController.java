package pl.equipment.store.application.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.equipment.store.domain.product.dto.ProductResponseDto;
import pl.equipment.store.domain.product.port.out.CreateProduct;
import pl.equipment.store.domain.product.port.out.FindProduct;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
class ProductController {

    private final CreateProduct createProduct;
    private final FindProduct findProduct;

    @PostMapping
    ProductResponseDto saveProduct(@RequestBody CreateProductRequest createProductRequest) {
        return createProduct.create(CreateProductRequest.toCreateProductDto(createProductRequest));
    }

    @GetMapping
    List<ProductResponseDto> getAllProducts() {
        return findProduct.findAll();
    }

}
