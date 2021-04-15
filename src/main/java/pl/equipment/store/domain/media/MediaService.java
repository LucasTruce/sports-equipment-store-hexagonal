package pl.equipment.store.domain.media;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.media.dto.ResponseMediaDto;
import pl.equipment.store.domain.media.dto.SaveMediaDto;
import pl.equipment.store.domain.media.dto.UploadMediaDto;
import pl.equipment.store.domain.media.port.in.MediaRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
class MediaService {
    private final MediaRepository mediaRepository;

    List<ResponseMediaDto> uploadFilesAndSaveToDatabase(UploadMediaDto uploadMediaDto) {
        List<SaveMediaDto> mediaList = mediaRepository.upload(uploadMediaDto.getFileList())
                .stream()
                .map(m -> Media.create(m, uploadMediaDto.getProductId()))
                .map(Media::toSaveMediaDto)
                .collect(Collectors.toList());

        return mediaRepository.save(mediaList);

    }
}