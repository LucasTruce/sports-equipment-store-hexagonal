package pl.equipment.store.domain.user;


import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.port.in.UserCommandRepository;
import pl.equipment.store.domain.user.port.out.UserCommand;
import pl.equipment.store.domain.user.port.shared.CreateUserDto;
import pl.equipment.store.domain.user.port.shared.UserDto;

@RequiredArgsConstructor
class UserCommandImpl implements UserCommand {

    private final UserCommandRepository userCommandRepository;

    @Override
    public UserDto createUser(CreateUserDto createUserDto) {
        User user = User.createUser(createUserDto.getUsername(), createUserDto.getPassword());
        return userCommandRepository.saveUser(UserMapper.toUserDto(user));
    }
}
