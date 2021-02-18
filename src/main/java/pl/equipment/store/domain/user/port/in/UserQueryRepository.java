package pl.equipment.store.domain.user.port.in;

import pl.equipment.store.domain.user.dto.UserIdentificationDto;

import java.util.List;

public interface UserQueryRepository {
    List<UserIdentificationDto> findAll();
}
