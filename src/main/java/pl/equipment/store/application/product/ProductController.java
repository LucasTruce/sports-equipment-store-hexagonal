package pl.equipment.store.application.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.equipment.store.domain.product.port.in.ProductPort;
import pl.equipment.store.domain.product.port.shared.ProductDto;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
class ProductController {

    private final ProductPort productPort;

    @PostMapping
    ProductDto addProduct(@RequestBody CreateProductRequest createProductRequest){
        return productPort.createProduct(createProductRequest.getName());
    }

    @GetMapping
    List<ProductDto> getProducts(){
        return productPort.getProducts();
    }

}
