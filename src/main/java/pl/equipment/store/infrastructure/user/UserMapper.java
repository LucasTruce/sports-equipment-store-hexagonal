package pl.equipment.store.infrastructure.user;

import pl.equipment.store.domain.user.dto.SaveUserDto;
import pl.equipment.store.domain.user.dto.UserResponseDto;

import java.util.HashSet;
import java.util.Set;

class UserMapper {
    static UserEntity toEntity(SaveUserDto saveUserDto) {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(2L, RoleName.ROLE_USER));
        return new UserEntity(saveUserDto.getId(),
                saveUserDto.getUsername(),
                saveUserDto.getPassword(),
                saveUserDto.getCreationDate(),
                true,
                false,
                false,
                false,
                roles);
    }

    static UserResponseDto toResponseDto(UserEntity userEntity) {
        return new UserResponseDto(userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getCreationDate());
    }
}
