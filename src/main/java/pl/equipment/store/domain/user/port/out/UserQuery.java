package pl.equipment.store.domain.user.port.out;

import pl.equipment.store.domain.user.port.shared.UserDto;

import java.util.List;

public interface UserQuery {
    List<UserDto> findAllUsers();
}
