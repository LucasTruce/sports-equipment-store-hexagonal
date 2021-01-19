package pl.equipment.store.domain.user.port.out;

import pl.equipment.store.domain.user.port.shared.UserDto;

public interface UserFacade {
    UserDto createUser(UserDto userDto);
}
