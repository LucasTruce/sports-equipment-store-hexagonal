package pl.equipment.store.domain.product;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.product.port.in.ProductRepository;
import pl.equipment.store.domain.product.port.out.ProductFacade;
import pl.equipment.store.domain.product.port.shared.ProductDto;

import java.util.List;


@RequiredArgsConstructor
public class ProductFacadeImpl implements ProductFacade {
    private final ProductRepository productRepository;

    @Override
    public ProductDto createProduct(String name) {
        Product product = Product.createProduct(name);
        return productRepository.save(ProductFactory.toProductDto(product));
    }

    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findProducts();
    }
}
