package pl.equipment.store.domain.media.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ResponseMediaDto {
    private final String fileName;
    private final String url;
}
