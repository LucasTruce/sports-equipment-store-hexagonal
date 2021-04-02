package pl.equipment.store.domain.user

import pl.equipment.store.domain.user.dto.CreateUserDto
import pl.equipment.store.domain.user.dto.UserResponseDto
import pl.equipment.store.infrastructure.user.InMemoryUserRepository
import spock.lang.Specification

class UserFacadeTest extends Specification {
    UserFacade facade = new UserDomainConfig().userFacade(new InMemoryUserRepository())
    CreateUserDto createUserDto = new CreateUserDto("test", "test")

    def "should find all users"() {
        setup:
        facade.create(createUserDto)
        when:
        List<UserResponseDto> users = facade.findAll()
        then:
        !users.isEmpty()
    }

    def "should create user"() {
        when:
        UserResponseDto savedUser = facade.create(createUserDto)
        then:
        savedUser.getUsername() == createUserDto.getUsername()
    }
}
