package pl.equipment.store.domain.user.port.in;

import pl.equipment.store.domain.user.port.shared.UserDto;

public interface UserRepository {
    UserDto saveUser(UserDto userDto);
}
