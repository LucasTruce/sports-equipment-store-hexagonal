package pl.equipment.store.domain.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class User {
    private Long id;
    private String username;
    private String password;
}
