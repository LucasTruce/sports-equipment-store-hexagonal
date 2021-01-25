package pl.equipment.store.domain.user.port.shared;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateUserDto {
    private final String username;
    private final String password;
}
