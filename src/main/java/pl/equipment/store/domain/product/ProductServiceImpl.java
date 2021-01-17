package pl.equipment.store.domain.product;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.product.port.in.ProductService;
import pl.equipment.store.domain.product.port.out.ProductRepository;
import pl.equipment.store.domain.product.port.shared.ProductDto;

@RequiredArgsConstructor
class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductDto createProduct(String productName) {
        Product product = Product.ProductFactory.getInstance().createProduct(productName);
        return productRepository.save(Product.ProductFactory.getInstance().toProductDto(product));
    }

}
