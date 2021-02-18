package pl.equipment.store.domain.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class SaveUserDto {
    private final Long id;
    private final String username;
    private final String password;
    private final LocalDateTime creationDate;
}
