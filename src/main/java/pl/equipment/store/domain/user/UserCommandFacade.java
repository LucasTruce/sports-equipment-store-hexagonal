package pl.equipment.store.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.dto.CreateUserDto;
import pl.equipment.store.domain.user.dto.UserIdentificationDto;
import pl.equipment.store.domain.user.port.in.UserCommandRepository;
import pl.equipment.store.domain.user.port.out.UserCommand;

@Getter
@RequiredArgsConstructor
class UserCommandFacade implements UserCommand {

    private final UserCommandRepository userCommandRepository;


    @Override
    public UserIdentificationDto createUser(CreateUserDto createUserDto) {
        User user = User.create(createUserDto.getUsername(), createUserDto.getPassword());
        return userCommandRepository.saveUser(UserMapper.toUserDto(user));
    }

}
