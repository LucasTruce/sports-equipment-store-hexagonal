package pl.equipment.store.domain.media;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.media.dto.ResponseMediaDto;
import pl.equipment.store.domain.media.dto.UploadMediaDto;
import pl.equipment.store.domain.media.port.out.UploadMedia;

import java.util.List;

@RequiredArgsConstructor
class MediaFacade implements UploadMedia {

    private final MediaService mediaService;

    @Override
    public List<ResponseMediaDto> upload(UploadMediaDto uploadMediaDto) {
        return mediaService.uploadFilesAndSaveToDatabase(uploadMediaDto);
    }
}
