package pl.equipment.store.infrastructure.user;

import pl.equipment.store.domain.user.dto.SaveUserDto;
import pl.equipment.store.domain.user.dto.UserResponseDto;

class UserMapper {
    static UserEntity toEntity(SaveUserDto saveUserDto) {
        return new UserEntity(saveUserDto.getId(),
                saveUserDto.getUsername(),
                saveUserDto.getPassword(),
                saveUserDto.getCreationDate());
    }

    static UserResponseDto toResponseDto(UserEntity userEntity) {
        return new UserResponseDto(userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getCreationDate());
    }
}
