package pl.equipment.store.domain.orderDetails

import io.vavr.control.Either
import pl.equipment.store.domain.order.dto.SaveOrderDto
import pl.equipment.store.domain.orderDetails.dto.CreateOrderDetailsDto
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

    OrderDetailsService service = new OrderDetailsService(repository, productRepository, orderRepository)
    OrderDetailsFacade facade = new OrderDetailsFacade(service)

    def "should create order details when product is in stock"() {
        setup:
            orderRepository.save(new SaveOrderDto(1L, "NEW_ORDER", BigDecimal.valueOf(0), 1L))
            productRepository.save(new SaveProductDto(1L, "test", "test", BigDecimal.valueOf(20), 10, "", true))
            CreateOrderDetailsDto createOrderDetailsDto = new CreateOrderDetailsDto(5, 1L, 1L)
        when:
            Either<OrderDetailsResponseError, OrderDetailsResponseDto> either = facade.create(createOrderDetailsDto)

        then:
            either.get().getOrderId() == createOrderDetailsDto.getOrderId()
            either.get().getProductId() == createOrderDetailsDto.getProductId()
    }
}
