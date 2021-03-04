package pl.equipment.store.domain.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.equipment.store.domain.user.dto.CreateUserDto;
import pl.equipment.store.domain.user.dto.SaveUserDto;

import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Setter
class User {
    private Long id;
    private String username;
    private String password;
    private LocalDateTime creationDate;

    static SaveUserDto create(CreateUserDto createUserDto) {
        User user = UserMapper.toUser(createUserDto);
        user.setId(null);
        user.setCreationDate(LocalDateTime.now());
        return UserMapper.toSaveUserDto(user);
    }
}
