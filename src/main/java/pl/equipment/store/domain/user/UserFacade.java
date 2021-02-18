package pl.equipment.store.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.dto.CreateUserDto;
import pl.equipment.store.domain.user.dto.UserIdentificationDto;
import pl.equipment.store.domain.user.port.in.UserCommandRepository;
import pl.equipment.store.domain.user.port.in.UserQueryRepository;
import pl.equipment.store.domain.user.port.out.UserCommand;
import pl.equipment.store.domain.user.port.out.UserQuery;

import java.util.List;

@Getter
@RequiredArgsConstructor
class UserFacade implements UserCommand, UserQuery {

    private final UserCommandRepository userCommandRepository;
    private final UserQueryRepository userQueryRepository;

    @Override
    public UserIdentificationDto createUser(CreateUserDto createUserDto) {
        User user = User.create(createUserDto.getUsername(), createUserDto.getPassword());
        return userCommandRepository.saveUser(UserMapper.toUserDto(user));
    }

    @Override
    public List<UserIdentificationDto> findAllUsers() {
        return userQueryRepository.findAll();
    }
}
