package pl.equipment.store.domain.user.port.in;

import pl.equipment.store.domain.user.dto.SaveUserDto;
import pl.equipment.store.domain.user.dto.UserResponseDto;

import java.util.List;

public interface UserRepository {
    UserResponseDto save(SaveUserDto saveUserDto);

    List<UserResponseDto> findAll();
}
