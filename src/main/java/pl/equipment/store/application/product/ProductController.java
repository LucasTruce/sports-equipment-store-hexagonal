package pl.equipment.store.application.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.equipment.store.domain.product.dto.ProductDto;
import pl.equipment.store.domain.product.port.out.ProductCommand;
import pl.equipment.store.domain.product.port.out.ProductQuery;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
class ProductController {

    private final ProductCommand productCommand;
    private final ProductQuery productQuery;

    @PostMapping
    ProductDto addProduct(@RequestBody CreateProductRequest createProductRequest){
        return productCommand.createProduct(createProductRequest.getName());
    }

    @GetMapping
    List<ProductDto> getProducts(){
        return productQuery.getProducts();
    }

}
