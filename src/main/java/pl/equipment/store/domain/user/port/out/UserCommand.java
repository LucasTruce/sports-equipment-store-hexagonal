package pl.equipment.store.domain.user.port.out;

import pl.equipment.store.domain.user.dto.CreateUserDto;
import pl.equipment.store.domain.user.dto.UserIdentificationDto;

public interface UserCommand {
    UserIdentificationDto createUser(CreateUserDto createUserDto);
}
