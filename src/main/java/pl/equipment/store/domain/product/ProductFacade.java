package pl.equipment.store.domain.product;

import lombok.Getter;
import pl.equipment.store.domain.product.port.in.ProductService;
import pl.equipment.store.domain.product.port.out.ProductRepository;

@Getter
public class ProductFacade {
    private final ProductService productService;

    public ProductFacade(ProductRepository productRepository){
        productService = new ProductServiceImpl(productRepository);
    }
}
