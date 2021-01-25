package pl.equipment.store.domain.user.port.shared;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {
    private final Long id;
    private final String username;
    private final String password;
    private final LocalDateTime creationDate;
}
