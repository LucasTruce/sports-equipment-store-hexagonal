package pl.equipment.store.domain.user.port.shared;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateUserDto {
    private final String username;
    private final String password;
}
