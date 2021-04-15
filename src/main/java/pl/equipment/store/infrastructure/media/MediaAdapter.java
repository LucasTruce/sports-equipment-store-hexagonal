package pl.equipment.store.infrastructure.media;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import pl.equipment.store.domain.media.dto.ResponseMediaDto;
import pl.equipment.store.domain.media.dto.SaveMediaDto;
import pl.equipment.store.domain.media.port.in.MediaRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class MediaAdapter implements MediaRepository {

    private final MediaSpringRepository mediaSpringRepository;
    private final Cloudinary cloudinary;

    @Override
    public List<ResponseMediaDto> upload(List<MultipartFile> files) {
        List<ResponseMediaDto> list = new ArrayList<>();
        for (MultipartFile file : files) {
            Try.of(file::getBytes)
                    .onSuccess(s -> Try.of(() -> uploadSingleFile(s))
                            .onSuccess(list::add));
        }
        return list;
    }

    @Override
    public List<ResponseMediaDto> save(List<SaveMediaDto> medias) {
        List<MediaEntity> list = medias.stream()
                .map(MediaMapper::toEntity)
                .collect(Collectors.toList());

        return mediaSpringRepository.saveAll(list)
                .stream()
                .map(MediaMapper::toResponse)
                .collect(Collectors.toList());
    }

    ResponseMediaDto uploadSingleFile(byte[] fileByte) throws IOException {
        var map = cloudinary.uploader().upload(fileByte, ObjectUtils.emptyMap());
        return new ResponseMediaDto(map.get("public_id").toString(), map.get("url").toString());
    }

}