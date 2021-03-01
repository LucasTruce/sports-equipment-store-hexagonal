package pl.equipment.store.domain.user.port.in;

import pl.equipment.store.domain.user.dto.SaveUserDto;
import pl.equipment.store.domain.user.dto.UserIdentificationDto;

import java.util.List;

public interface UserRepository {
    UserIdentificationDto saveUser(SaveUserDto saveUserDto);
    List<UserIdentificationDto> findAll();
}
