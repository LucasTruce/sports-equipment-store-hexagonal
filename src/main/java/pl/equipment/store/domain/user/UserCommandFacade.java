package pl.equipment.store.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.dto.CreateUserDto;
import pl.equipment.store.domain.user.dto.UserResponseDto;
import pl.equipment.store.domain.user.port.in.UserRepository;
import pl.equipment.store.domain.user.port.out.UserCommand;

@Getter
@RequiredArgsConstructor
class UserCommandFacade implements UserCommand {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(CreateUserDto createUserDto) {
        return userRepository.saveUser(User.create(createUserDto));
    }

}
