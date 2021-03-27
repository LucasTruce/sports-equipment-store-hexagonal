package pl.equipment.store.domain.user.port.out;

import pl.equipment.store.domain.user.dto.CreateUserDto;
import pl.equipment.store.domain.user.dto.UserResponseDto;

public interface CreateUser {
    UserResponseDto create(CreateUserDto createUserDto);
}
