package pl.equipment.store.domain.user.port.in;

import pl.equipment.store.domain.user.port.shared.UserDto;

import java.util.List;

public interface UserQueryRepository {
    List<UserDto> findAll();
}
