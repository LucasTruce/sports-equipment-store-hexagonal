package pl.equipment.store.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.dto.CreateUserDto;
import pl.equipment.store.domain.user.dto.UserResponseDto;
import pl.equipment.store.domain.user.port.out.CreateUser;
import pl.equipment.store.domain.user.port.out.FindUser;

import java.util.List;

@Getter
@RequiredArgsConstructor
class UserFacade implements CreateUser, FindUser {

    private final UserService userService;

    @Override
    public UserResponseDto create(CreateUserDto createUserDto) {
        return userService.save(createUserDto);
    }

    @Override
    public List<UserResponseDto> findAll() {
        return userService.findAll();
    }

}
