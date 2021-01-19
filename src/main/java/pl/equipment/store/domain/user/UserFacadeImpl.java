package pl.equipment.store.domain.user;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.port.in.UserRepository;
import pl.equipment.store.domain.user.port.out.UserFacade;
import pl.equipment.store.domain.user.port.shared.UserDto;

@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        return userRepository.saveUser(userDto);
    }
}
