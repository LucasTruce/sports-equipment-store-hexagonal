package pl.equipment.store.domain.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Builder
class Product {
    private Long id;
    private String name;

    static Product createProduct(String productName){
        return new Product(null, productName);
    }


}
