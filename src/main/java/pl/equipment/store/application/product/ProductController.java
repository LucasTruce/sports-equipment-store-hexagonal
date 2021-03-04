package pl.equipment.store.application.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.equipment.store.domain.product.dto.ProductResponseDto;
import pl.equipment.store.domain.product.port.out.ProductCommand;
import pl.equipment.store.domain.product.port.out.ProductQuery;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
class ProductController {

    private final ProductCommand productCommand;
    private final ProductQuery productQuery;

    @PostMapping
    ProductResponseDto saveProduct(@RequestBody CreateProductRequest createProductRequest) {
        return productCommand.createProduct(CreateProductRequest.toCreateProductDto(createProductRequest));
    }

    @GetMapping
    List<ProductResponseDto> getAllProducts() {
        return productQuery.findAllProducts();
    }

}
