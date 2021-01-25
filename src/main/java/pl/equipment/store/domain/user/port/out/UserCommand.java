package pl.equipment.store.domain.user.port.out;

import pl.equipment.store.domain.user.port.shared.CreateUserDto;
import pl.equipment.store.domain.user.port.shared.UserDto;

public interface UserCommand {
    UserDto createUser(CreateUserDto createUserDto);
}
