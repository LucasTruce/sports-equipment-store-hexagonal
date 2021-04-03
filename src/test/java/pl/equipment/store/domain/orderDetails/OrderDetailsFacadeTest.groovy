package pl.equipment.store.domain.orderDetails

import io.vavr.control.Either
import pl.equipment.store.domain.order.dto.SaveOrderDto
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsProductDto
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseError
import pl.equipment.store.domain.orderDetails.port.in.OrderDatabase
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsRepository
import pl.equipment.store.domain.orderDetails.port.in.ProductDatabase
import pl.equipment.store.domain.product.dto.SaveProductDto
import pl.equipment.store.infrastructure.order.InMemoryOrderRepository
import pl.equipment.store.infrastructure.orderDetails.InMemoryOrderDetailsRepository
import pl.equipment.store.infrastructure.product.InMemoryProductRepository
import spock.lang.Specification

class OrderDetailsFacadeTest extends Specification {
    OrderDetailsRepository repository = new InMemoryOrderDetailsRepository()
    OrderDatabase orderRepository = new InMemoryOrderRepository()
    ProductDatabase productRepository = new InMemoryProductRepository()
    OrderDetailsFacade facade = new OrderDetailsDomainConfig().orderDetailsFacade(repository, productRepository, orderRepository)

    SaveOrderDto saveOrderDto = new SaveOrderDto(1L, "NEW_ORDER", BigDecimal.valueOf(0), 1L)
    SaveProductDto saveProductDto = new SaveProductDto(1L, "test", "test", BigDecimal.valueOf(20), 10, "", true)
    SaveProductDto notInStockProductDto = new SaveProductDto(1L, "test", "test", BigDecimal.valueOf(20), 0, "", true)
    CreateOrderDetailsDto createOrderDetailsDto = new CreateOrderDetailsDto(5, saveOrderDto.getId(), saveProductDto.getId())

    def "should create order details when product is in stock and update product and order current values"() {
        setup:
        orderRepository.save(saveOrderDto)
        productRepository.save(saveProductDto)

        when:
        Either<OrderDetailsResponseError, OrderDetailsResponseDto> either = facade.create(createOrderDetailsDto)
        OrderDetailsProductDto orderDetailsProductDto = productRepository.getPriceAndUnitsInStock(saveProductDto.getId()).getOrNull()
        BigDecimal totalPrice = orderRepository.getTotalPrice(saveOrderDto.getId()).getOrNull()

        then:
        either.get().getOrderId() == createOrderDetailsDto.getOrderId()
        either.get().getProductId() == createOrderDetailsDto.getProductId()
        either.get().getQuantity() == createOrderDetailsDto.getQuantity()
        either.get().getId() == 1L

        orderDetailsProductDto.getUnitsInStock() == 5
        orderDetailsProductDto.getUnitPrice() == saveProductDto.getUnitPrice()
        totalPrice == BigDecimal.valueOf(100)
    }

    def "should find all order details"() {
        setup:
        orderRepository.save(saveOrderDto)
        productRepository.save(saveProductDto)
        facade.create(createOrderDetailsDto)

        when:
        List<OrderDetailsResponseDto> list = facade.findAll()

        then:
        !list.isEmpty()
    }


    def "should get error when product not exists"() {
        when:
        Either<OrderDetailsResponseError, OrderDetailsResponseDto> either = facade.create(createOrderDetailsDto)

        then:
        either.getLeft().getMessage() == "Product not found!"
    }

    def "should get error when order not exists"() {
        setup:
        productRepository.save(saveProductDto)

        when:
        Either<OrderDetailsResponseError, OrderDetailsResponseDto> either = facade.create(createOrderDetailsDto)

        then:
        either.getLeft().getMessage() == "Order not found!"
    }

    def "should get error when product is not in stock"() {
        setup:
        orderRepository.save(saveOrderDto)
        productRepository.save(notInStockProductDto)

        when:
        Either<OrderDetailsResponseError, OrderDetailsResponseDto> either = facade.create(createOrderDetailsDto)

        then:
        either.getLeft().getMessage() == "Product not in stock!"
    }
}
