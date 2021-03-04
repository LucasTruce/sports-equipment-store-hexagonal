package pl.equipment.store.domain.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.equipment.store.domain.product.dto.CreateProductDto;
import pl.equipment.store.domain.product.dto.SaveProductDto;

import java.math.BigDecimal;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Setter
class Product {
    private Long id;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private int unitsInStock;
    private String imageUrl;
    private boolean active;

    static SaveProductDto create(CreateProductDto productDto) {
        Product product = ProductMapper.toProduct(productDto);
        product.setImageUrl("test url");
        product.setActive(true);
        return ProductMapper.toSaveProductDto(product);
    }

}
