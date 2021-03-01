package pl.equipment.store.domain.orderDetails;

import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsError;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsRepository;
import pl.equipment.store.domain.orderDetails.port.out.OrderDetailsCommand;
import pl.equipment.store.domain.product.port.in.ProductRepository;

import java.time.LocalDateTime;

@RequiredArgsConstructor
class OrderDetailsCommandFacade implements OrderDetailsCommand {

    private final OrderDetailsRepository repository;
    private final ProductRepository productRepository;

    @Override
    public Either<OrderDetailsError, OrderDetailsResponseDto> createOrderDetails(CreateOrderDetailsDto createOrderDetailsDto) {
        OrderDetails orderDetails = OrderDetails.create(createOrderDetailsDto.getQuantity(), createOrderDetailsDto.getOrderId(), createOrderDetailsDto.getProductId());

        int units = productRepository.getUnitsInStock(createOrderDetailsDto.getProductId());

        if(createOrderDetailsDto.getQuantity() <= units) {
            productRepository.updateUnitsInStock(createOrderDetailsDto.getProductId(), units - createOrderDetailsDto.getQuantity());
            return Either.right(repository.saveOrderDetails(OrderDetailsMapper.toOrderDetailsResponseDto(orderDetails)));
        }
        return Either.left(new OrderDetailsError("Can't create OrderDetails, quantity too big!", LocalDateTime.now()));
    }
}
