package pl.equipment.store.domain.media;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.media.dto.ResponseMediaDto;
import pl.equipment.store.domain.media.dto.SaveMediaDto;

@RequiredArgsConstructor
class Media {
    private final Long id;
    private final String fileName;
    private final String url;
    private final Long productId;

    static Media create(ResponseMediaDto mediaDto, Long productId) {
        return new Media(null, mediaDto.getFileName(), mediaDto.getUrl(), productId);
    }

    SaveMediaDto toSaveMediaDto() {
        return new SaveMediaDto(id, fileName, url, productId);
    }
}
