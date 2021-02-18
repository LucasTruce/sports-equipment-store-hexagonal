package pl.equipment.store.domain.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class Product {
    private final Long id;
    private final String name;

    static Product create(String productName){
        return new Product(null, productName);
    }

}
