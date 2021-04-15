package pl.equipment.store.infrastructure.media;

import pl.equipment.store.domain.media.dto.ResponseMediaDto;
import pl.equipment.store.domain.media.dto.SaveMediaDto;
import pl.equipment.store.infrastructure.product.ProductEntity;

class MediaMapper {

    static MediaEntity toEntity(SaveMediaDto saveMediaDto) {
        return new MediaEntity(saveMediaDto.getId(),
                saveMediaDto.getFileName(),
                saveMediaDto.getUrl(),
                new ProductEntity(saveMediaDto.getProductId(),
                        null,
                        null,
                        null,
                        0,
                        false));
    }

    static ResponseMediaDto toResponse(MediaEntity mediaEntity) {
        return new ResponseMediaDto(
                mediaEntity.getFileName(),
                mediaEntity.getUrl());
    }
}
