package pl.equipment.store.domain.user.port.in;

import pl.equipment.store.domain.user.dto.SaveUserDto;
import pl.equipment.store.domain.user.dto.UserIdentificationDto;

public interface UserCommandRepository {
    UserIdentificationDto saveUser(SaveUserDto saveUserDto);
}
