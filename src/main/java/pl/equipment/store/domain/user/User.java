package pl.equipment.store.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.dto.CreateUserDto;
import pl.equipment.store.domain.user.dto.SaveUserDto;

import java.time.LocalDateTime;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class User {
    private final Long id;
    private final String username;
    private final String password;
    private final LocalDateTime creationDate;

    static SaveUserDto create(CreateUserDto createUserDto) {
        User user = new User(null, createUserDto.getUsername(), createUserDto.getPassword(), LocalDateTime.now());
        return UserMapper.toSaveUserDto(user);
    }
}
