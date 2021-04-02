package pl.equipment.store.domain.order

import io.vavr.control.Either
import pl.equipment.store.domain.order.dto.OrderResponseError
import pl.equipment.store.domain.order.dto.ResponseOrderDto
import pl.equipment.store.domain.order.port.in.OrderRepository
import pl.equipment.store.domain.order.port.in.UserDatabase
import pl.equipment.store.domain.user.dto.SaveUserDto
import pl.equipment.store.domain.user.dto.UserResponseDto
import pl.equipment.store.infrastructure.order.InMemoryOrderRepository
import pl.equipment.store.infrastructure.user.InMemoryUserRepository
import spock.lang.Specification

import java.time.LocalDateTime

class OrderFacadeTest extends Specification {
    OrderRepository orderRepository = new InMemoryOrderRepository()
    UserDatabase userDatabase = new InMemoryUserRepository()
    OrderFacade orderFacade = new OrderDomainConfig().orderFacade(orderRepository, userDatabase)

    SaveUserDto userDto = new SaveUserDto(1L, "test", "test", LocalDateTime.now())

    def "should get error when user not exists"() {
        when:
        Either<OrderResponseError, ResponseOrderDto> create = orderFacade.create(1L)
        then:
        create.getLeft().getMessage() == "User not found!"
    }

    def "should create order when user exists"() {
        setup:
        UserResponseDto savedUser = userDatabase.save(userDto)

        when:
        Either<OrderResponseError, ResponseOrderDto> create = orderFacade.create(savedUser.getId())

        then:
        create.get().getStatus() == "NEW_ORDER"
        create.get().getTotalPrice() == 0L

    }

    def "should find all orders"() {
        setup:
        UserResponseDto savedUser = userDatabase.save(userDto)
        orderFacade.create(savedUser.getId())
        orderFacade.create(savedUser.getId())

        when:
        List<ResponseOrderDto> list = orderFacade.findAll()

        then:
        !list.isEmpty()
        list.size() == 2
    }

    def "should find order by id"() {
        setup:
        UserResponseDto savedUser = userDatabase.save(userDto)
        Either<OrderResponseError, ResponseOrderDto> createdOrder = orderFacade.create(savedUser.getId())

        when:
        Either<OrderResponseError, ResponseOrderDto> findOrder = orderFacade.findById(createdOrder.get().getId())

        then:
        findOrder.get().getId() == createdOrder.get().getId()
    }


}
