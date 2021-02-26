package pl.equipment.store.application.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.order.dto.CreateOrderDto;

import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@Getter
class CreateOrderRequest {
    @NotBlank
    private final String status;
    private final Long userId;

    static CreateOrderDto toCreateOrderDto(CreateOrderRequest createOrderRequest){
        return new CreateOrderDto(createOrderRequest.getStatus(), createOrderRequest.getUserId());
    }
}
