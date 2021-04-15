package pl.equipment.store.domain.media.port.in;

import org.springframework.web.multipart.MultipartFile;
import pl.equipment.store.domain.media.dto.ResponseMediaDto;
import pl.equipment.store.domain.media.dto.SaveMediaDto;

import java.util.List;

public interface MediaRepository {
    List<ResponseMediaDto> upload(List<MultipartFile> files);

    List<ResponseMediaDto> save(List<SaveMediaDto> medias);

    List<ResponseMediaDto> findAllByProductId(Long productId);
}
