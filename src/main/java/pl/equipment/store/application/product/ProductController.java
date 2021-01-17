package pl.equipment.store.application.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.equipment.store.domain.product.ProductFacade;
import pl.equipment.store.domain.product.port.shared.ProductDto;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
class ProductController {

    private final ProductFacade productFacade;

    @PostMapping
    ProductDto addProduct(@RequestBody CreateProductRequest createProductRequest){
        return productFacade.getProductService().createProduct(createProductRequest.getName());
    }

}
