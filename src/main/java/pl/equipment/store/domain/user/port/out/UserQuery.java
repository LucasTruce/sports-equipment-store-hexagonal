package pl.equipment.store.domain.user.port.out;

import pl.equipment.store.domain.user.dto.UserIdentificationDto;

import java.util.List;

public interface UserQuery {
    List<UserIdentificationDto> findAllUsers();
}
