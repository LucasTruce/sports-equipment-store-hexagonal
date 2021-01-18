package pl.equipment.store.domain.user;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.user.port.shared.UserDto;

class UserFactory {

    private static final UserFactory instance = new UserFactory();

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    User createUser(UserDto userDto){
        return new User(0L, userDto.getUsername(), userDto.getPassword());
    }

    UserDto toUserDto(User user){
        return userMapper.toUserDto(user);
    }

    @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface UserMapper {
        UserDto toUserDto(User user);
    }
}
