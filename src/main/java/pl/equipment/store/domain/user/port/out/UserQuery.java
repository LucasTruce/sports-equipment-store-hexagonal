package pl.equipment.store.domain.user.port.out;

import pl.equipment.store.domain.user.dto.UserResponseDto;

import java.util.List;

public interface UserQuery {
    List<UserResponseDto> findAllUsers();
}
