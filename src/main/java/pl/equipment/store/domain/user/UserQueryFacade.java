package pl.equipment.store.domain.user;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.dto.UserIdentificationDto;
import pl.equipment.store.domain.user.port.in.UserRepository;
import pl.equipment.store.domain.user.port.out.UserQuery;

import java.util.List;

@RequiredArgsConstructor
class UserQueryFacade implements UserQuery {

    private final UserRepository userRepository;

    @Override
    public List<UserIdentificationDto> findAllUsers() {
        return userRepository.findAll();
    }
}
