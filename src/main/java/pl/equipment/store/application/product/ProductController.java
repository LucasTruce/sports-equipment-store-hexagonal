package pl.equipment.store.application.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.equipment.store.domain.product.port.shared.ProductDto;
import pl.equipment.store.infrastructure.product.spring.ProductAppService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
class ProductController {

    private final ProductAppService productService;

    @PostMapping
    ProductDto addProduct(@RequestBody CreateProductRequest createProductRequest){
        return productService.createProduct(createProductRequest.getName());
    }

    @GetMapping
    List<ProductDto> getProducts(){
        return productService.getProducts();
    }

}
