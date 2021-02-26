package pl.equipment.store.application.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.product.dto.CreateProductDto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@Getter
class CreateProductRequest {
    @NotBlank
    private final String name;
    @NotBlank
    private final String description;
    @Min(1)
    private final double unitPrice;
    private final int unitsInStock;

    static CreateProductDto toCreateProductDto(CreateProductRequest productRequest){
        return new CreateProductDto(productRequest.getName(), productRequest.getDescription(), productRequest.unitPrice, productRequest.unitsInStock);
    }
}
