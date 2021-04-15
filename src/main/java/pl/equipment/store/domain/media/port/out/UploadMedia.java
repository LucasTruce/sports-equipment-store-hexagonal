package pl.equipment.store.domain.media.port.out;

import pl.equipment.store.domain.media.dto.ResponseMediaDto;
import pl.equipment.store.domain.media.dto.UploadMediaDto;

import java.util.List;

public interface UploadMedia {
    List<ResponseMediaDto> upload(UploadMediaDto uploadMediaDto);
}
