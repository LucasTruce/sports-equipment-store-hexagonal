package pl.equipment.store.infrastructure.product.spring;

import lombok.experimental.Delegate;
import org.springframework.stereotype.Service;
import pl.equipment.store.domain.product.ProductFacade;
import pl.equipment.store.domain.product.port.in.ProductService;

@Service
class ProductAppService implements ProductService {

    @Delegate
    private final ProductService productService;

    public ProductAppService(ProductFacade productFacade) {
        productService = productFacade.getProductService();
    }
}
