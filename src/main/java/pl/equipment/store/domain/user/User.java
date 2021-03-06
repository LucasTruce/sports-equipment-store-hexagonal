package pl.equipment.store.domain.user;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.dto.CreateUserDto;
import pl.equipment.store.domain.user.dto.SaveUserDto;

import java.time.LocalDateTime;

@RequiredArgsConstructor
class User {
    private final Long id;
    private final String username;
    private final String password;
    private final LocalDateTime creationDate;

    static User create(CreateUserDto createUserDto) {
        return new User(
                null,
                createUserDto.getUsername(),
                createUserDto.getPassword(),
                LocalDateTime.now());
    }

    SaveUserDto toSaveUserDto() {
        return new SaveUserDto(id, username, password, creationDate);
    }
}
