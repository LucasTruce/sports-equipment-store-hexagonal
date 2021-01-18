package pl.equipment.store.domain.user;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.port.in.UserPort;
import pl.equipment.store.domain.user.port.out.UserRepository;
import pl.equipment.store.domain.user.port.shared.UserDto;

@RequiredArgsConstructor
public class UserFacade implements UserPort {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        return userRepository.saveUser(userDto);
    }
}
