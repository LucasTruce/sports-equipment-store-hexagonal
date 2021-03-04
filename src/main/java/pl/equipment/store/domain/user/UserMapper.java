package pl.equipment.store.domain.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.user.dto.CreateUserDto;
import pl.equipment.store.domain.user.dto.SaveUserDto;

class UserMapper {
    private static final IUserMapper userMapper = Mappers.getMapper(IUserMapper.class);

    static SaveUserDto toSaveUserDto(User user) {
        return userMapper.toSaveUserDto(user);
    }

    static User toUser(CreateUserDto createUserDto) {
        return userMapper.toUser(createUserDto);
    }

    @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
    interface IUserMapper {
        SaveUserDto toSaveUserDto(User user);

        @Mapping(target = "id", ignore = true)
        @Mapping(target = "creationDate", ignore = true)
        User toUser(CreateUserDto createUserDto);

    }
}
