package pl.equipment.store.domain.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class UserIdentificationDto {
    private final Long id;
    private final String username;
    private final LocalDateTime creationDate;
}
