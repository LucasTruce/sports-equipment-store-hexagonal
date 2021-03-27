package pl.equipment.store.application.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.equipment.store.domain.product.dto.CreateProductDto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
class CreateProductRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @Min(1)
    private BigDecimal unitPrice;
    private int unitsInStock;

    static CreateProductDto toCreateProductDto(CreateProductRequest productRequest) {
        return new CreateProductDto(productRequest.getName(),
                productRequest.getDescription(),
                productRequest.unitPrice,
                productRequest.unitsInStock);
    }
}
