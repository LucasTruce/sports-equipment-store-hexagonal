package pl.equipment.store.domain.media.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SaveMediaDto {
    private final Long id;
    private final String fileName;
    private final String url;
    private final Long productId;
}
