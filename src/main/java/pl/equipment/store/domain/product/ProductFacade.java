package pl.equipment.store.domain.product;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.product.port.in.ProductPort;
import pl.equipment.store.domain.product.port.out.ProductRepository;
import pl.equipment.store.domain.product.port.shared.ProductDto;

import java.util.List;


@RequiredArgsConstructor
public class ProductFacade implements ProductPort{
    private final ProductRepository productRepository;

    @Override
    public ProductDto createProduct(String name) {
        Product product = Product.ProductFactory.getInstance().createProduct(name);
        return productRepository.save(Product.ProductFactory.getInstance().toProductDto(product));
    }

    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findProducts();
    }
}
