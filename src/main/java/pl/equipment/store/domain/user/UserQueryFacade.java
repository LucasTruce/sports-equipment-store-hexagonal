package pl.equipment.store.domain.user;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.dto.UserIdentificationDto;
import pl.equipment.store.domain.user.port.in.UserQueryRepository;
import pl.equipment.store.domain.user.port.out.UserQuery;

import java.util.List;

@RequiredArgsConstructor
class UserQueryFacade implements UserQuery {

    private final UserQueryRepository userQueryRepository;

    @Override
    public List<UserIdentificationDto> findAllUsers() {
        return userQueryRepository.findAll();
    }
}
