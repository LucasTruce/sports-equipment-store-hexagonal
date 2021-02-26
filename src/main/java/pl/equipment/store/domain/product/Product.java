package pl.equipment.store.domain.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class Product {
    private final Long id;
    private final String name;
    private final String description;
    private final double unitPrice;
    private final int unitsInStock;
    private final String imageUrl;
    private final boolean active;

    static Product create(String productName, String description, double unitPrice, int unitsInStock){
        return new Product(null, productName, description, unitPrice, unitsInStock, "", true);
    }

}
