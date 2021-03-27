package pl.equipment.store.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.dto.CreateUserDto;
import pl.equipment.store.domain.user.dto.SaveUserDto;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
class User {
    private final Long id;
    private final String username;
    private final String password;
    private final LocalDateTime creationDate;

    static SaveUserDto create(CreateUserDto createUserDto) {
        return new SaveUserDto(
                null,
                createUserDto.getUsername(),
                createUserDto.getPassword(),
                LocalDateTime.now());
    }
}
