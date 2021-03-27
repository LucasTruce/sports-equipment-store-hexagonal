package pl.equipment.store.domain.orderDetails;

import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsProductDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseError;
import pl.equipment.store.domain.orderDetails.port.in.OrderDatabase;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsRepository;
import pl.equipment.store.domain.orderDetails.port.in.ProductDatabase;

import java.util.List;

@RequiredArgsConstructor
class OrderDetailsService {
    private final OrderDetailsRepository repository;
    private final ProductDatabase productRepository;
    private final OrderDatabase orderRepository;

    Either<OrderDetailsResponseError, OrderDetailsResponseDto> createOrderDetails(CreateOrderDetailsDto createOrderDetailsDto) {

        final OrderDetailsProductDto foundProduct = productRepository.getPriceAndUnitsInStock(createOrderDetailsDto.getProductId()).getOrNull();
        final int quantity = createOrderDetailsDto.getQuantity();
//
//        return productRepository.getPriceAndUnitsInStock(createOrderDetailsDto.getProductId())
//                .toEither(() -> new OrderDetailsResponseError("Product not found!"))
//                .filter(product -> product.isAvailable(quantity))
//                .flatMap(product -> productRepository.updateUnitsInStock(createOrderDetailsDto.getProductId(), getTotalUnitsInStock(quantity, product.getUnitsInStock())))
//                .toEither(() -> new OrderDetailsResponseError("Product not found or not in stock!"))
//                .flatMap(productId -> orderRepository.getTotalPrice(createOrderDetailsDto.getOrderId())
//                        .map(totalPrice -> totalPrice.add(foundProduct.calculateTotalOrderPrice(quantity)))
//                        .flatMap(totalPrice -> orderRepository.updateTotalPrice(createOrderDetailsDto.getOrderId(), totalPrice))
//                        .toEither(() -> new OrderDetailsResponseError("Order not found!"))
//                        .map(orderId -> repository.save(OrderDetails.create(createOrderDetailsDto))));

        return productRepository.getPriceAndUnitsInStock(createOrderDetailsDto.getProductId())
                .toEither(() -> new OrderDetailsResponseError("Product not found!"))
                .map(product -> checkIfProductIsInStockAndGetUnits(quantity, product))
                .flatMap(option -> option
                        .flatMap(unitsInStock -> productRepository.updateUnitsInStock(createOrderDetailsDto.getProductId(), getTotalUnitsInStock(quantity, unitsInStock)))
                        .toEither(() -> new OrderDetailsResponseError("Product not in stock!")))
                .map(productId -> orderRepository.getTotalPrice(createOrderDetailsDto.getOrderId()))
                .flatMap(option -> option
                        .map(totalPrice -> totalPrice.add(foundProduct.calculateTotalOrderPrice(quantity)))
                        .flatMap(totalPrice -> orderRepository.updateTotalPrice(createOrderDetailsDto.getOrderId(), totalPrice))
                        .toEither(() ->  new OrderDetailsResponseError("Order not found!")))
                .map(s -> repository.save(OrderDetails.create(createOrderDetailsDto)));
    }

    public List<OrderDetailsResponseDto> findAllOrderDetails() {
        return repository.findAll();
    }

    private Integer getTotalUnitsInStock(int quantity, Integer unitsInStock) {
        return Option.of(unitsInStock)
                .map(units -> units - quantity)
                .getOrNull();
    }

    private Option<Integer> checkIfProductIsInStockAndGetUnits(int quantity, OrderDetailsProductDto product) {
        return Option.of(product)
                .filter(prod -> prod.isAvailable(quantity))
                .map(OrderDetailsProductDto::getUnitsInStock);
    }
}
