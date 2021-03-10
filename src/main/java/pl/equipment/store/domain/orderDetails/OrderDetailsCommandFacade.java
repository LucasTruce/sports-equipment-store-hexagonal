package pl.equipment.store.domain.orderDetails;

import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsProductDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseError;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsRepository;
import pl.equipment.store.domain.orderDetails.port.out.OrderDetailsCommand;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

@RequiredArgsConstructor
class OrderDetailsCommandFacade implements OrderDetailsCommand {

    private final OrderDetailsRepository repository;

    @Override
    public Either<OrderDetailsResponseError, OrderDetailsResponseDto> createOrderDetails(CreateOrderDetailsDto createOrderDetailsDto) {

        final Option<OrderDetailsProductDto> product = repository.getProductPriceAndUnits(createOrderDetailsDto.getProductId());
        final Option<BigDecimal> unitPrice = product.map(OrderDetailsProductDto::getUnitPrice);
        final Option<Integer> unitsInStock = product.map(OrderDetailsProductDto::getUnitsInStock);
        final Option<BigDecimal> orderTotalPrice = repository.getOrderTotalPrice(createOrderDetailsDto.getOrderId());

        int totalUnitsInStock;
        BigDecimal totalOrderPrice;

        Either<OrderDetailsResponseError, OrderDetailsProductDto> e1 = product
                .map((Function<OrderDetailsProductDto, Either<OrderDetailsResponseError, OrderDetailsProductDto>>)
                        Either::right)
                .getOrElse(Either.left(new OrderDetailsResponseError("Product not found!", LocalDateTime.now())));

        Either<OrderDetailsResponseError, BigDecimal> e2 = orderTotalPrice
                .map((Function<BigDecimal, Either<OrderDetailsResponseError, BigDecimal>>) Either::right)
                .getOrElse(Either.left(new OrderDetailsResponseError("Order not found!", LocalDateTime.now())));



        if (isProductInStock(createOrderDetailsDto.getQuantity(), unitsInStock.getOrNull())) {
           totalOrderPrice = orderTotalPrice.getOrNull().add(unitPrice.getOrNull().multiply(BigDecimal.valueOf(createOrderDetailsDto.getQuantity())));
           totalUnitsInStock = unitsInStock.getOrNull() - createOrderDetailsDto.getQuantity();
           return Either.right(repository.save(OrderDetails.create(createOrderDetailsDto, totalOrderPrice, totalUnitsInStock)));
        }
        return Either.left(new OrderDetailsResponseError("Products not in stock!", LocalDateTime.now()));
    }

    private boolean isProductInStock(int quantity, Integer unitsInStock)
    {
        return Option.of(unitsInStock)
                .map(u -> u >= quantity)
                .getOrElse(false);
    }
}
