package pl.equipment.store.domain.user;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.user.port.shared.UserDto;

class UserMapper {
    private static final IUserMapper userMapper = Mappers.getMapper(IUserMapper.class);

    static UserDto toUserDto(User user){
        return userMapper.toUserDto(user);
    }

    @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface IUserMapper {
        UserDto toUserDto(User user);

    }
}
