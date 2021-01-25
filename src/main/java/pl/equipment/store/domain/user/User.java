package pl.equipment.store.domain.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class User {
    private final Long id;
    private final String username;
    private final String password;
    private final LocalDateTime creationDate;

    static User createUser(String username, String password){
        return new User(null, username, password, LocalDateTime.now());
    }
}
