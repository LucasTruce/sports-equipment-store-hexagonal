package pl.equipment.store.domain.user.port.in;

import pl.equipment.store.domain.user.port.shared.UserDto;

public interface UserPort {
    UserDto createUser(UserDto userDto);
}
