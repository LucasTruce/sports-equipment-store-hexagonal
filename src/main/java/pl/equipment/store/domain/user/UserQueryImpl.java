package pl.equipment.store.domain.user;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.port.in.UserQueryRepository;
import pl.equipment.store.domain.user.port.out.UserQuery;
import pl.equipment.store.domain.user.port.shared.UserDto;

import java.util.List;

@RequiredArgsConstructor
class UserQueryImpl implements UserQuery {

    private final UserQueryRepository userQueryRepository;

    @Override
    public List<UserDto> findAllUsers() {
        return userQueryRepository.findAll();
    }
}
