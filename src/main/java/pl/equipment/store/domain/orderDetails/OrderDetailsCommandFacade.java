package pl.equipment.store.domain.orderDetails;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsProductDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseError;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsRepository;
import pl.equipment.store.domain.orderDetails.port.out.OrderDetailsCommand;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
class OrderDetailsCommandFacade implements OrderDetailsCommand {

    private final OrderDetailsRepository repository;

    @Override
    public Either<OrderDetailsResponseError, OrderDetailsResponseDto> createOrderDetails(CreateOrderDetailsDto createOrderDetailsDto) {

        OrderDetailsProductDto product = repository.getProductPriceAndUnits(createOrderDetailsDto.getProductId());
        double orderTotalPrice = repository.getOrderTotalPrice(createOrderDetailsDto.getOrderId()).doubleValue();
        int productUnitsInStock;

        if (createOrderDetailsDto.getQuantity() <= product.getUnitsInStock()) {
            orderTotalPrice += product.getUnitPrice().doubleValue() * createOrderDetailsDto.getQuantity();
            productUnitsInStock = product.getUnitsInStock() - createOrderDetailsDto.getQuantity();
            return Either.right(repository.saveOrderDetails(OrderDetails.create(createOrderDetailsDto, BigDecimal.valueOf(orderTotalPrice), productUnitsInStock)));
        }
        return Either.left(new OrderDetailsResponseError("Products not in stock!", LocalDateTime.now()));
    }
}
