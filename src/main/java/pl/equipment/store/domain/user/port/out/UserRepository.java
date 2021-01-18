package pl.equipment.store.domain.user.port.out;

import pl.equipment.store.domain.user.port.shared.UserDto;

public interface UserRepository {
    UserDto saveUser(UserDto userDto);
}
